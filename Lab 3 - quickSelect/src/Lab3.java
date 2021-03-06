//Note for professor:
// For part A, I made two versions for comparison.
// I'm interested to know which one is more efficient in terms of runtime and memory space.

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Lab3 {

    public static void main(String[] args)
    {
        //part A
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Part A\nPlease enter a positive integer: ");
        int n = in.nextInt();
        int[] partA = new int[n];
        for (int i = 0; i < partA.length; i++)
            partA[i] = rand.nextInt(201) - 100;
        for (int num : partA)
            System.out.print(num + " ");
        System.out.print("\nEnter a number from 1 to n: ");
        int k = in.nextInt();
        System.out.printf("%dth least element = %d\n", k, quickSelectA(partA, k, 0, partA.length));


        //partB
        int[] bExample = {4, 2, 0, 10, 1, 6};
        int[] bExampleMax = quickSelectB(bExample, 3, 0, bExample.length);
        System.out.print("\nPart B\nExample: {4, 2, 0, 10, 1, 6} = ");
        for (int num : bExampleMax)
            System.out.print(num + " ");

        System.out.print("\nPlease enter a positive integer: ");
        n = in.nextInt();
        int[] partB = new int[n];
        for (int i = 0; i < partB.length; i++)
            partB[i] = rand.nextInt(201) - 100;
        for (int num : partB)
            System.out.print(num + " ");
        System.out.print("\nEnter a number from 1 to n: ");
        k = in.nextInt();

        System.out.printf("Max %d elements = ", k);
        int[] partBOutput = quickSelectB(partB, k, 0, partB.length);
        for (int num : partBOutput)
            System.out.print(num + " ");

        in.close();
    }

    //quickSelect using low and high integers.
    public static int quickSelectA(int[] a, int k, int low, int high)
    {
        int pivotIndex = partition(a, low, high) + 1;

        if (k < pivotIndex)
            pivotIndex = quickSelectA(a, k, low, pivotIndex - 1);
        else if (k > pivotIndex)
            pivotIndex = quickSelectA(a, k, pivotIndex, high);
        else
            pivotIndex--;

        return pivotIndex;
    }

    //return max k numbers from an array
    public static int[] quickSelectB(int[] a, int k, int low, int high)
    {
        int pivotIndex = partition(a, low, high) + 1;
        int kMax = a.length - k;

        if (kMax < pivotIndex)
            a = quickSelectB(a, k, 0, pivotIndex - 1);
        else if (kMax > pivotIndex)
            a = quickSelectB(a, k, pivotIndex, a.length);
        else
            a = Arrays.copyOfRange(a, kMax, a.length);

        return a;
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = high - 1;
        int leftMarker = low;
        int rightMarker = pivot - 1;

        if (high - low == 1) { // an array of 1 is already sorted
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

        return pivot; //sorted pivot position
    }

    /*
    //quickSelect using sub-arrays.
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
     */
}
