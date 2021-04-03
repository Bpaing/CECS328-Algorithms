import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Lab5 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        /*
        System.out.print("Enter size n: ");
        int n = in.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(41) - 20;

        double[] test = MPSS(arr);
         */

        double[] example = {2, -3, 1, 4, -6, 10, -12, 5.2, 3.6, -8};
        double result = MPSS(example);
        System.out.println(result);
    }

    public static double MPSS(double[] a)
    {
        if (a.length == 1) {
            if (a[0] < 0)
                return Double.MAX_VALUE;   // to ignore negative values
            return a[0];
        }
        int mid = a.length / 2;

        double mpssLeft = MPSS(Arrays.copyOfRange(a, 0, mid));
        double mpssRight = MPSS(Arrays.copyOfRange(a, mid, a.length));

        double[] left = Arrays.copyOfRange(a, 0, mid); // n
        Arrays.sort(left);
        double[] right = Arrays.copyOfRange(a, mid, a.length); // n

        double sum = a[mid];
        for (int i = mid + 1; i < a.length; i++) { // right side
            sum += a[i];
            if (sum < mpss && sum > 0)
                mpss = sum;
        }
        for (int i = mid - 1; i > -1; i--) { // left side
            sum += a[i];
            if (sum < mpss && sum > 0)
                mpss = sum;
        }

        return Math.min(Math.min(mpssLeft, mpssRight), mpssMid);
    }

}
