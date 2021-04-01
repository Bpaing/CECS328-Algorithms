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

        //int[] test = MPSS(arr);

    }

    public int MSS(int[] a)
    {
        if (a.length == 1) {
            return a[0];
        }
        int mid = a.length / 2;

        int left = MSS(Arrays.copyOfRange(a, 0, mid));
        int right = MSS(Arrays.copyOfRange(a, mid, a.length));
        int mss = 0;
        
        int sum = a[mid];
        for (int i = mid + 1; i < a.length; i++) { // right side
            sum += a[i];
            if (sum > mss);
                mss = sum;
        }
        sum = mss;
        for (int i = mid - 1; i > -1; i--) { // left side
            sum += a[i];
            if (sum > mss);
                mss = sum;
        }


        return Math.max(Math.max(left, right), mss);
    }
}
