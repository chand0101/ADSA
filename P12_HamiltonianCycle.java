import java.util.Arrays;
import java.util.Scanner;

public class P12_HamiltonianCycle {
    static int n;
    static int[][] graph;
    static int[] path;

    public static boolean isSafe(int vertex, int position) {
        if (graph[path[position - 1]][vertex] == 0) {
            return false;
        }

        for (int i = 0; i < position; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    public static boolean hamiltonian(int position) {
        if (position == n) {
            if (graph[path[position - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        for (int vertex = 1; vertex < n; vertex++) {
            if (isSafe(vertex, position)) {
                path[position] = vertex;

                if (hamiltonian(position + 1)) {
                    return true;
                }

                path[position] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        path = new int[n];
        Arrays.fill(path, -1);
        path[0] = 0;

        if (hamiltonian(1)) {
            System.out.println("Hamiltonian Cycle:");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println(path[0]);
        } else {
            System.out.println("No Hamiltonian Cycle exists");
        }

        sc.close();
    }
}