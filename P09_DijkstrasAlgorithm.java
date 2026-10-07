import java.util.Scanner;

public class P09_DijkstrasAlgorithm {
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

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = 999;
            visited[i] = false;
        }

        distance[source] = 0;

        for (int i = 0; i < n; i++) {
            int minimum = 999;
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && distance[j] < minimum) {
                    minimum = distance[j];
                    u = j;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDistance = distance[u] + graph[u][v];

                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                    }
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < n; i++) {
            System.out.println(source + " to " + i + " = " + distance[i]);
        }

        sc.close();
    }
}