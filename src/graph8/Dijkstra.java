package graph8;

/**
 * @Description:
 * @Class: Dijkstra
 * @Package: graph8
 * @Author: hedgeway
 * @CreateTime: 2023/3/24 21:14
 */

import java.util.*;

public class Dijkstra {
    static final int MAXN = 10;
    static final int INF = 0x3f3f3f3f;

    static int n, m; // 图的节点数和边数
    static int start, end; // 起点和终点
    static int[] dist = new int[MAXN]; // 存储起点到每个节点的最短距离
    static int[] path = new int[MAXN]; // 存储起点到每个节点的最短路径
    static int[][] G = new int[MAXN][MAXN]; // 图的邻接矩阵

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        start = in.nextInt();
        end = in.nextInt();
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                G[i][j] = INF;
            }
        }
        // 读入边的信息并建图
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            G[u][v] = G[v][u] = w;
        }
        // 初始化dist[]和path[]数组
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);
        Dijkstra();
        // 输出起点到终点的最短路径和路径大小
        System.out.println("最短路径：" + getPath(start, end));
        System.out.println("路径大小：" + dist[end]);
        // 输出起点到每个顶点的最短路径和路径大小
        System.out.println("起点到每个顶点的最短路径与路径大小：");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + getPath(start, i) + " " + dist[i]);
        }
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 起点的最短距离为0
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll().v;
            for (int v = 1; v <= n; v++) {
                if (G[u][v] != INF && dist[u] + G[u][v] < dist[v]) {
                    dist[v] = dist[u] + G[u][v];
                    path[v] = u;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
    }

    // 获取起点到终点的最短路径
    public static String getPath(int start, int end) {
        StringBuilder sb = new StringBuilder();
        int cur = end;
        while (cur != start) {
            sb.insert(0, cur + " ");
            cur = path[cur];
        }
        sb.insert(0, start + " ");
        return sb.toString();
    }

    static class Node implements Comparable<Node> {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }
    }
}
