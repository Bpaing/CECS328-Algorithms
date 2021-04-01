import java.util.Scanner;
import java.util.Random;

public class Lab6 {
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter a positive integer: ");
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = random.nextInt(201) - 100;
        heap_sort(a);


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
    
    
    public void heap_sort(int[] a)
    {
        build_MaxHeap(a);
    }

    public void build_MaxHeap(int[] a)
    {
        int n = a.length;
        for (int i = n; i > 0; i++) {

            max_heapify(a, i, n);
        }
    }
    
    public void max_heapify(int[] a, int node, int n) {
        int max = node;
        int left = 2 * node;
        int right = (2 * node) + 1;

        if (a[left] > a[node] && left < n)
            max = left;
        if (a[right] > a[node] && right < n)
            max = right;

        if (max != node) {
            int temp = a[max];
            a[max] = a[node];
            a[node] = temp;
            max_heapify(a, max, n);
        }
    }
    
    public void selection_sort(int[] a) 
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
