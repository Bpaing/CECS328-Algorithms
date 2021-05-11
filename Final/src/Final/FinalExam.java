package Final;

public class FinalExam {

    public static void main(String args[])
    {
        Graph problem3 = Graph.problem3();
        problem3.minimumCost(problem3.getVertex(0));
        int[] one = {1, 2, 3, 4};
        int[] two = {2, 3, 1, 4};
        int[] three = {3, 4, 2, 1};

        System.out.println("\nExample 1: Input: [1, 2, 3, 4]");
        minSwap(one);
        System.out.println("\nExample 2: Input: [2, 3, 1, 4]");
        minSwap(two);
        System.out.println("\nExample 3: Input: [3, 4, 2, 1]");
        minSwap(three);
    }

    public static void minSwap(int[] arr)
    {
        int min = 0;
        for (int i = 0; i < arr.length && min < arr.length - 1; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                min++;
                i--;
            }
        }
        if (min == 0)
            System.out.println("No need to do any swaps! You win!");
        else
            System.out.printf("The min nr of swaps is: %d\n", min);
    }
}
