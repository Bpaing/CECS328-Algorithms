import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Lab5 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter size n: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(41) - 20;

        int[] test = MPSS(arr);

    }

    public double MPSS(int[] a)
    {
        double mpss = Integer.MAX_VALUE;
        if (a.length == 1) {
            return a[0];
        }
        int mid = a.length / 2;

        double left = MPSS(Arrays.copyOfRange(a, 0, mid));
        double right = MPSS(Arrays.copyOfRange(a, right, a.length));
        double compare = Math.max(left, right);

        mpss = Math.min(mpss, compare);



    }
}
