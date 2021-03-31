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
        
    }
    public void build_MaxHeap(int[] a)
    {
        
    }
    
    public void max_heapify(int[] a, int i)
    {
        
    }
    
    public void selection_sort(int[] a) 
    {
        
    }
    
    
    
}
