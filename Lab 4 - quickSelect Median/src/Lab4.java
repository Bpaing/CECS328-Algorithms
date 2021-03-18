import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Lab4 {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int n;
        while (true) {
            System.out.print("Enter a positive integer 'n': ");
            n = in.nextInt();
            if (n > 0)
                break;
        }
        int k;
        while(true) {
            System.out.print("Enter an integer from 1 to n: ");
            k = in.nextInt();
            if (k > 0 && k <= n)
                break;
        }
        

    }

    public static int[] medianNeighbors(int[] a, int k)
    {
        return a;
    }

    //sub-array quickSelect from lab 3
    public static int quickSelectA(int[] a, int k)
    {
        int pivotIndex = partition(a) + 1;
        int value = 0;

        if (k < pivotIndex)
            value = quickSelectA(Arrays.copyOfRange(a, 0, pivotIndex - 1), k);
        else if (k > pivotIndex)
            value = quickSelectA(Arrays.copyOfRange(a, pivotIndex, a.length), k - pivotIndex);
        else
            return a[--pivotIndex];

        return value;
    }

    private static int partition(int[] a) {
        int pivot = a.length - 1;
        int leftMarker = 0;
        int rightMarker = pivot - 1;
        if (a.length == 1) { // an array of 1 is already sorted
            return pivot;
        }
        while (leftMarker < rightMarker) {
            while (a[leftMarker] < a[pivot] && leftMarker < rightMarker) {
                leftMarker++;
            }
            while (a[rightMarker] >= a[pivot] && rightMarker > leftMarker) {
                rightMarker--;
            }
            //both markers frozen, swap marker values
            if (a[leftMarker] >= a[pivot] && a[rightMarker] <= a[pivot]) {
                int temp = a[leftMarker];
                a[leftMarker] = a[rightMarker];
                a[rightMarker] = temp;
            }
        }
        //final pivot value swap
        if (a[pivot] < a[leftMarker]) {
            int temp = a[leftMarker];
            a[leftMarker] = a[pivot];
            a[pivot] = temp;
        }
        pivot = leftMarker;
        return pivot; //new pivot index
    }
}
