import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Lab2_Q2 {

    public static void main(String[] args) {
        int[] Example1 = {0, 1, 3, 6, 8, 9};
        int[] Example2 = {2, 5, 7, 11};
        int[] Example3 = {0, 1, 2, 3, 4};
        int[] Example4 = {12};
        System.out.printf("Example 1 = %d\n", findSmallest(Example1));
        System.out.printf("Example 2 = %d\n", findSmallest(Example2));
        System.out.printf("Example 3 = %d\n", findSmallest(Example3));
        System.out.printf("Example 4 = %d\n", findSmallest(Example4));

        Scanner input = new Scanner(System.in);
        System.out.print("m = ");
        int m = input.nextInt();
        int n;
        while (true) {
            System.out.print("n = ");
            n = input.nextInt();
            if (n < m)
                break;
            System.out.println("n must be an integer less than m.");
        }
        input.close();

        int[] a = generateArray(m, n);
        for(int num : a)
            System.out.print(num + " ");
        System.out.printf("\nSmallest missing value = %d", findSmallest(a));
    }

    //finds the smallest missing value in a sorted array of distinct integers.
    //distinct numbers from 0 to m, so values can't be less than their index.
    //Therefore, smallest missing value is the smallest position where value != index
    public static int findSmallest(int[] a)
    {
        int smallestNum = a[a.length - 1] + 1;
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] > mid) {
                smallestNum = mid;
                high = mid - 1;
            } else if (a[mid] == mid) {
                smallestNum = mid + 1;
                low = mid + 1;
            }
        }
        return smallestNum;
    }

    //generates a sorted list of distinct integers.
    public static int[] generateArray(int m, int n)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i <= m; i++) {               //add the entire range to a list.
            temp.add(i);
        }
        for (int i = temp.size(); i > n; i--) {     //removes random indices from list.
            temp.remove(rand.nextInt(i));
        }
        int[] a = new int[temp.size()];             //copy to an array then return.
        for (int i = 0; i < temp.size(); i++) {
            a[i] = temp.get(i);
        }
        return a;
    }
}
