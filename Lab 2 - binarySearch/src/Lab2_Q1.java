import java.util.Scanner;

public class Lab2_Q1 {

    public static int sqrt(int num)
    {
        int low = 0;
        int high = num;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int check = mid * mid;
            if (low == high) {
                if (check < num) //return the ceiling if sqrt(num) is not a whole number.
                    return high + 1;
                return high;
            } else if (check < num) {
                low = mid + 1;
            } else if (check > num) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to square root: ");
        int num = input.nextInt();
        System.out.printf("sqrt(%d) = %d", num, sqrt(num));
        input.close();
    }
}

