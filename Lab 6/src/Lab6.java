import java.util.Scanner;
import java.util.Random;

public class Lab6 {
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Part A\nEnter a positive integer: ");
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = random.nextInt(201) - 100;
        heap_sort(a);
        for (int num : a)
            System.out.print(num + " ");

        int runtimeHeap = 0;
        int runtimeSelect = 0;
        for (int reps = 0; reps < 100; reps++) {
            int[] aHeap = new int[1000];
            int[] aSelect = new int[1000];
            for (int i = 0; i < 1000; i++) {
                aHeap[i] = random.nextInt(201) - 100;
                aSelect[i] = random.nextInt(201) - 100;
            }
            long start = System.nanoTime();
            heap_sort(aHeap);
            runtimeHeap += (System.nanoTime() - start);
            start = System.nanoTime();
            selection_sort(aSelect);
            runtimeSelect += (System.nanoTime() - start);
        }
        runtimeHeap /= 100;
        runtimeSelect /= 100;
        System.out.printf("\n\nn = 1000\nHeap Sort (nlogn) average runtime: %d ns\n" +
                "Selection Sort (n^2) average runtime: %d ns\n\n", runtimeHeap, runtimeSelect);


        System.out.println("Part B");
        int[] b = new int[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(201) - 100;
            System.out.print(b[i] + " ");
        }
        heap_sort(b);
        for (int num : b)
            System.out.print(num + " ");

        in.close();
    }
    
    
    public static void heap_sort(int[] a)
    {
        //build heap
        // (a.length / 2 - 1) represents the last internal node.
        // time would be wasted calling max_heapify on nodes without children.
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            max_heapify(a, i, a.length);
        }

        //sort
        for (int end = a.length - 1; end > 0; end--) {
            int temp = a[end];
            a[end] = a[0];
            a[0] = temp;
            max_heapify(a, 0, end);
        }
    }

    public static void max_heapify(int[] a, int node, int n) {
        int max = node;
        int left = (2 * node) + 1;
        int right = (2 * node) + 2;

        if (left < n && a[left] > a[max])
            max = left;
        if (right < n && a[right] > a[max])
            max = right;

        if (max != node) {
            int temp = a[max];
            a[max] = a[node];
            a[node] = temp;
            max_heapify(a, max, n);
        }
    }
    
    public static void selection_sort(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    
    
    
}
