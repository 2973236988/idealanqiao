package graph5;

/**
 * @Description:
 * @Class: Dijkstra
 * @Package: graph5
 * @Author: hedgeway
 * @CreateTime: 2023/3/22 16:58
 */

/**
 *
 * Dijkstra算法是一种单源最短路径算法，用于计算一个节点到其他所有节点的最短路径。
 * 它的主要思想是从起点开始，逐步扩大最短路径的范围，直到扩大到终点为止。Dijkstra算法的实现流程如下：
 *
 * 创建一个数组dist，用于存储起点到各个节点的距离，初始值为无穷大。
 * 将起点的距离设为0，表示起点到自己的距离为0。
 * 创建一个数组visited，用于记录每个节点是否被访问过，初始值为false。
 * 从dist数组中找到距离起点最近的节点，将其标记为visited。
 * 遍历该节点的所有邻居节点，更新它们到起点的距离。
 * 重复步骤4和5，直到所有节点都被访问过。
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 3, 0, 0},
                {1, 0, 1, 4, 2},
                {3, 1, 0, 5, 0},
                {0, 4, 5, 0, 6},
                {0, 2, 0, 6, 0}
        };
        int[] dist = dijkstra(graph, 0);
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance from 0 to " + i + " is " + dist[i]);
        }
    }

    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0;
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
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

