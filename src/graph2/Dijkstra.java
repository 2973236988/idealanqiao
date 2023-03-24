package graph2;

import java.util.Arrays;

/**
 * @Description:
 * @Class: dijkstra
 * @Package: graph2
 * @Author: hedgeway
 * @CreateTime: 2023/3/22 16:42
 */

public class Dijkstra {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {2, 0, 2, 4, 2, 0},
                {4, 2, 0, 0, 3, 0},
                {0, 4, 0, 0, 3, 2},
                {0, 2, 3, 3, 0, 2},
                {0, 0, 0, 2, 2, 0}
        };
        int start = 0;
        int[] dist = dijkstra(graph, start);
        System.out.println(Arrays.toString(dist));
    }

    public static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    public static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

