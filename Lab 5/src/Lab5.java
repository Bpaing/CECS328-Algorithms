import java.util.Scanner;
import java.util.Random;

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

        
    }
}
