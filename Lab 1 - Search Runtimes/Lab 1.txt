import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Lab1
{
    public static void main(String[] args)
    {
        Lab1 test = new Lab1();
        test.PartA();
        test.PartB();
        test.PartC();
    }

    public Lab1()
    {
        input = new Scanner(System.in);
        rand = new Random();
    }


    public void PartA()
    {
        System.out.print("Part A - Enter a positive integer: ");
        n = input.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(1001 + 1000) - 1000; // -1000 to 1001 exclusive
        }
        Arrays.sort(a);

        int key = a[rand.nextInt(n)];
        System.out.println("Linear Search: Key " + key + " found in index " + linearSearch(a, key));
        System.out.println("Binary Search: Key " + key + " found in index " + binarySearch(a, key));

        System.out.println("\nAverage-Running Time");
        int totalTime = 0;
        for (int i = 0; i < 100; i++) {
            key = a[rand.nextInt(n)];
            long start = System.nanoTime();
            linearSearch(a, key);
            long estimated = System.nanoTime();
            totalTime += estimated - start;
        }
        System.out.println("Linear Search: " + (totalTime / 100) + " ns");
        totalTime = 0;
        for (int i = 0; i < 100; i++) {
            key = a[rand.nextInt(n)];
            long start = System.nanoTime();
            binarySearch(a, key);
            long estimated = System.nanoTime();
            totalTime += estimated - start;
        }
        System.out.println("Binary Search: " + (totalTime / 100) + " ns\n");
    }

    public void PartB()
    {
        System.out.print("Part B - Enter a positive integer: ");
        n = input.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(1001 + 1000) - 1000; // -1000 to 1001 exclusive
        }
        Arrays.sort(a);

        int key = 5000;
        System.out.println("Linear Search: Key " + key + " found in index " + linearSearch(a, key));
        System.out.println("Binary Search: Key " + key + " found in index " + binarySearch(a, key));

        System.out.println("\nWorst-Case Running Time");
        int totalTime = 0;
        long start = System.nanoTime();
        linearSearch(a, key);
        long estimated = System.nanoTime();
        totalTime += estimated - start;
        System.out.println("Linear Search: " + totalTime + " ns");

        totalTime = 0;
        start = System.nanoTime();
        binarySearch(a, key);
        estimated = System.nanoTime();
        totalTime += estimated - start;
        System.out.println("Binary Search: " + totalTime + " ns\n");

        double singleLine = totalTime / Math.log(n);
        System.out.println("Binary Search Single Line: " + singleLine + " ns\n");
        /*
            B6. The time complexity of binary search = O(log n). That means for an input size 'n', the worst-case scenario
            would require at most 'log n' operations or line executions. When also given the total time it takes for a
            machine to execute the algorithm, calculations can be made to relate # of lines to time.

            'n' input size requires at most 'log n' operations
            So the time needed for a single line can be found using (totalTime / log n)

                 n size           total time
            ----------------  *  -----------
            log n operations       n size
         */

        double estimateTime = Math.log(Math.pow(10, 15)) * singleLine;
        System.out.println("10^15 worst-case: " + estimateTime + " ns\n");
        /*
            B6. The value found in number 4 represents the amount of time it takes to execute a single line of code.
            As mentioned before, binary-search has a time complexity of O(log n). To estimate the time needed to
            execute an algorithm, calculate the expression inside (log n) using the given input size. This represents
            the largest number of operations needed to execute the algorithm, which can be multiplied by the single line
            operation value to roughly estimate the total time.

            log(10^15) operations * time per operation
         */

    }

    public void PartC()
    {
        System.out.print("Part C - Enter a positive integer: ");
        n = input.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(1001 + 1000) - 1000; // -1000 to 1001 exclusive
        }
        Arrays.sort(a);
        System.out.println("There exists an 'i' where a[i] = i at index: " + binarySearchPartC(a));
    }

    public int linearSearch(int[] a, int key)
    {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    public int binarySearch(int[] a, int key)
    {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public boolean binarySearchPartC(int[] a)
    {
        /*
            If a[mid] > mid, then we can ignore all values from indices 'mid' to 'a[mid]'
            If a[mid] < mid, then we can ignore all values from indices 'a[mid]' to 'mid'
            This leaves us with two potential halves to check:
                a[mid] to a.length  if first iteration a[mid] > mid
                0 to a[mid]         if first iteration a[mid] < mid

            When one half is exhausted or out of bounds, check the other half.
         */

        int low = 0;
        int high = a.length;
        int temp = 0;


        while (true) {

            int mid = (low + high) / 2;
            if(a[mid] == mid) {
                return true;
            } else if (low == high) {
                break;
            } else if (a[mid] > mid) {
                temp = low;
                low = a[mid];
            } else if (a[mid] < mid) {
                temp = high;
                high = a[mid];
            }

            if (low >= high) {
                if (high <= 0) {            //first half exhausted
                    low = mid + 1;
                    high = temp;
                } else if (low > high) {    //second half exhausted
                    low = temp;
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    private Scanner input;
    private Random rand;
    private int n;
    private int[] a;

}
