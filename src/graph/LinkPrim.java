package graph;

import java.util.*;

/**
 * @Description:
 * @Class: LinkPrim
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/18 23:12
 */

public class LinkPrim {
    private static final int INF = Integer.MAX_VALUE; // 无穷大
    private int V; // 顶点数
    private List<List<Edge>> graph; // 邻接表

    public LinkPrim(int V) {
        this.V = V;
        graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        graph.get(u).add(new Edge(v, weight));
        graph.get(v).add(new Edge(u, weight));
    }

    public int primMST() {
        int[] key = new int[V]; // 存储每个顶点的key值
        int[] parent = new int[V]; // 存储每个顶点的父亲结点
        boolean[] inMST = new boolean[V]; // 存储每个顶点是否在MST中
        Arrays.fill(key, INF); // 初始化所有的key值为无穷大
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(e -> e.weight)); // 存储与MST相邻的边

        // 任选一个顶点作为起点
        int src = 0;
        pq.add(new Edge(src, 0));
        key[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().to;
            inMST[u] = true;

            for (Edge e : graph.get(u)) {
                int v = e.to;
                int weight = e.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        // 计算MST的权值和
        int mstWeight = 0;
        for (int i = 0; i < V; i++) {
            if (inMST[i]) {
                mstWeight += key[i];
            }
        }

        return mstWeight;
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {
        LinkPrim g = new LinkPrim(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);
        int mstWeight = g.primMST();
        System.out.println("MST的权值和为：" + mstWeight); // 16
    }
}



