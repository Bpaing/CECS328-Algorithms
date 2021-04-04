import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Lab5 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter size n: ");
        int n = in.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(41) - 20;
            System.out.print(arr[i] + " ");
        }
        System.out.printf(String.format("\nMPSS = %.1f\n", MPSS(arr)));

        double[] example = {2, -3, 1, 4, -6, 10, -12, 5.2, 3.6, -8};
        System.out.println("\nExample array");
        for (double val : example)
            System.out.print(val + " ");
        System.out.printf(String.format("\nMPSS = %.1f\n", MPSS(example)));
    }

    public static double MPSS(double[] a)
    {
        if (a.length == 1) {
            if (a[0] <= 0)
                return Double.MAX_VALUE;   // to ignore negative values and zero
            return a[0];
        }
        int mid = a.length / 2;

        double mpssLeft = MPSS(Arrays.copyOfRange(a, 0, mid));
        double mpssRight = MPSS(Arrays.copyOfRange(a, mid, a.length));

        double ssL[] = new double[mid];
        double ssR[] = new double[mid];
        double sumLeft = 0, sumRight = 0;
        for (int pos = 1; pos <= mid; pos++) {
            if (mid - pos >= 0) {   //left sum array
                sumLeft += a[mid - pos];
                ssL[pos-1] = sumLeft;
            }
            if (mid + pos < a.length) { //right sum array
                sumRight += a[mid + pos];
                ssR[pos-1] = sumRight;
            }
        }
        Arrays.sort(ssL);   //nlogn
        Arrays.sort(ssR);   //nlogn

        double min = Double.MAX_VALUE;
        int i = 0;
        int j = ssR.length - 1;
        while (i < ssL.length && j > -1) {
            double sum = a[mid] + (ssL[i] + ssR[j]);
            if (sum <= 0) {
                i++;
            } else if (sum < min) {
                min = sum;
                j--;
            } else {
                j--;
            }
        }
        double mpssMid = min;

        return Math.min(Math.min(mpssLeft, mpssRight), mpssMid);
    }

}
