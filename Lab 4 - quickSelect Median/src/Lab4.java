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
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(201) - 100;
        for (int num : a)
            System.out.print(num + " ");

        int k;
        while(true) {
            System.out.print("\nEnter an integer from 1 to n: ");
            k = in.nextInt();
            if (k > 0 && k <= n)
                break;
        }

        int median = quickSelect(a, a.length/2);
        int[] diff = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            diff[i] = a[i] - median;
            if (diff[i] == 0)   //To ignore values that equal median
                k++;
        }
        int[] result = medianNeighbors(diff, k, 0, diff.length);
        System.out.printf("%d closest values to median '%d'\n", k, quickSelect(a, a.length/2));
        for (int num: result)
            System.out.print(num + " ");

    }

    //Lab 3 part B modified
    private static int[] medianNeighbors(int[] a, int k, int low, int high)
    {
        int pivotIndex = partitionAbs(a, low, high) + 1;

        if (k < pivotIndex)
            a = medianNeighbors(a, k, 0, pivotIndex - 1);
        else if (k > pivotIndex)
            a = medianNeighbors(a, k, pivotIndex, a.length);
        else
            a = Arrays.copyOfRange(a, 0, k);

        return a;
    }

    private static int partitionAbs(int[] a, int low, int high) {
        int pivot = high - 1;
        int leftMarker = 0;
        int rightMarker = pivot - 1;
        if (a.length == 1) { // an array of 1 is already sorted
            return pivot;
        }
        while (leftMarker < rightMarker) {
            while (Math.abs(a[leftMarker]) < Math.abs(a[pivot]) && leftMarker < rightMarker) {
                leftMarker++;
            }
            while (Math.abs(a[rightMarker]) >= Math.abs(a[pivot]) && rightMarker > leftMarker) {
                rightMarker--;
            }
            //both markers frozen, swap marker values
            if (Math.abs(a[leftMarker]) >= Math.abs(a[pivot]) && Math.abs(a[rightMarker]) <= Math.abs(a[pivot])) {
                int temp = a[leftMarker];
                a[leftMarker] = a[rightMarker];
                a[rightMarker] = temp;
            }
        }
        //final pivot value swap
        if (Math.abs(a[pivot]) < Math.abs(a[leftMarker])) {
            int temp = a[leftMarker];
            a[leftMarker] = a[pivot];
            a[pivot] = temp;
        }
        pivot = leftMarker;
        return pivot; //new pivot index
    }


    //sub-array quickSelect from lab 3
    public static int quickSelect(int[] a, int k)
    {
        int pivotIndex = partition(a) + 1;
        int value;

        if (k < pivotIndex)
            value = quickSelect(Arrays.copyOfRange(a, 0, pivotIndex - 1), k);
        else if (k > pivotIndex)
            value = quickSelect(Arrays.copyOfRange(a, pivotIndex, a.length), k - pivotIndex);
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
