package Lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab7 {

    public static void main(String args[])
    {
        //part A
        Scanner in = new Scanner(System.in);
        Graph example = Graph.generateExampleA();
        System.out.print("Part A\nExample Graph\nPlease enter initial vertex from a - h to perform BFS: ");
        char c = in.next().charAt(0);
        example.BFS(example.getVertex(c));

        System.out.print("\n\nRandom Graph\nPlease enter number of vertices: ");
        int v = in.nextInt();
        System.out.printf("Please enter number of edges, max %d: ", (v * (v+1)) / 2);
        int e = in.nextInt();
        example = Graph.generateRandom(v, e);
        System.out.printf("Please enter initial vertex from %s - %s to perform BFS: ",
                example.getGraph().get(0), example.getGraph().get(example.size() - 1));
        c = in.next().charAt(0);
        example.BFS(example.getVertex(c));
        in.close();

        System.out.println("Part B\nExample Graph");
        example = Graph.generateExampleB();
    }

}


