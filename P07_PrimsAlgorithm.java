import java.util.Scanner;

public class P07_PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] selected = new boolean[n];
        selected[0] = true;

        System.out.println("Edges in MST:");

        int total = 0;

        for (int i = 0; i < n - 1; i++) {
            int minimum = 999;
            int x = 0;
            int y = 0;

            for (int j = 0; j < n; j++) {
                if (selected[j]) {
                    for (int k = 0; k < n; k++) {
                        if (!selected[k] && graph[j][k] != 0 && graph[j][k] < minimum) {
                            minimum = graph[j][k];
                            x = j;
                            y = k;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + minimum);

            total += minimum;
            selected[y] = true;
        }

        System.out.println("Minimum cost: " + total);

        sc.close();
    }
}