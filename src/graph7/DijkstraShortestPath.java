package graph7;

/**
 * @Description:
 * @Class: DijkstraShortestPath
 * @Package: graph7
 * @Author: hedgeway
 * @CreateTime: 2023/3/24 20:53
 */
import java.util.*;

public class DijkstraShortestPath {
    public static void shortestPath(int[][] graph, int src, int dest) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = findMinDist(dist, visited);
            visited[u] = true;
            if (u == dest) {
                break;
            }
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int u = dest;
        while (u != src) {
            path.add(u);
            u = prev[u];
        }
        path.add(src);
        Collections.reverse(path);

        System.out.println("Shortest path from " + src + " to " + dest + ": " + path);
        System.out.println("Shortest distance from " + src + " to " + dest + ": " + dist[dest]);

        System.out.println("Shortest distances from " + src + " to all vertices:");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + ": unreachable");
            } else {
                System.out.println(i + ": " + dist[i]);
            }
        }
    }

    private static int findMinDist(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int src = 0;
        int dest = 8;
        shortestPath(graph, src, dest);
    }
}

