import java.util.Scanner;
import java.util.Random;

public class Lab6 {
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
     /*
        System.out.print("Enter a positive integer: ");
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = random.nextInt(201) - 100;
        heap_sort(a);
*/

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
        for (int i = a.length / 2 - 1; i > 0; i--) {
            max_heapify(a, i, a.length);
        }

        //sort
        for (int end = a.length - 1; end > -1; end--) {
            int temp = a[end];
            a[end] = a[0];
            a[0] = temp;
            max_heapify(a, 0, end);
        }
    }
    
    public static void max_heapify(int[] a, int node, int n) {
        int max = node;
        int left = 2 * node;
        int right = (2 * node) + 1;

        if (left < n && a[left] > a[node])
            max = left;
        if (right < n && a[right] > a[node])
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
