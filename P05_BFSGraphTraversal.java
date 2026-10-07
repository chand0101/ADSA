import java.util.*;

public class P05_BFSGraphTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge: ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        System.out.println("BFS traversal:");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.print(vertex + " ");

            for (int neighbour : graph.get(vertex)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
        sc.close();
    }
}