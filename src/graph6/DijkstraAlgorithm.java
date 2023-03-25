package graph6;

/**
 * @Description:
 * @Class: Dijkstra
 * @Package: graph6
 * @Author: hedgeway
 * @CreateTime: 2023/3/24 20:34
 */
/**

 在这个例子中，我们用邻接矩阵表示带权有向图，计算从顶点0到其他顶点的最短路径。
 程序首先将dist数组初始化为无穷大，将源点0到自身的距离设为0。然后在每一次循环中，
 找到未被标记的距离最小的顶点u，将其标记为已找到最短路径，并更新源点到u的邻居v的最短路径。
 最终，dist数组中存储的就是从源点到其他顶点的最短距离。

 */

public class DijkstraAlgorithm {

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
        int[] dist = dijkstra(graph, 0);
        System.out.println("顶点0到其他各顶点的最短距离为：");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("顶点" + i + "的最短距离为：" + dist[i]);
        }
    }

    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n]; // 存储源点到各个顶点的最短距离
        boolean[] visited = new boolean[n]; // 记录顶点是否被访问过

        // 初始化dist数组和visited数组
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0; // 源点到自身的距离为0

        // 找到n-1个顶点的最短路径
        for (int i = 0; i < n - 1; i++) {
            int u = findMinDist(dist, visited); // 找到未被标记的距离最小的顶点u
            visited[u] = true; // 标记顶点u为已找到最短路径

            // 更新源点到u的邻居v的最短路径
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    // 找到未被标记的距离最小的顶点
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
}