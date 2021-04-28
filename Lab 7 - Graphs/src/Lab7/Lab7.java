package Lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab7 {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Graph example = Graph.generateExample();
        System.out.println("Example Graph\nPlease enter a vertex from a - h");
        char c = in.next().charAt(0);
        Graph.BFS(example.getVertex(c));
    }

}


