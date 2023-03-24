package graph;

/**
 * @Description:
 * @Class: DFS
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/17 12:36
 */
import java.util.ArrayList;

public class Graph {

    // 存储图中每个节点的邻接表，其中adj[v]存储的是与节点v相邻的所有节点
    private ArrayList<Integer>[] adj;

    // 构造函数，初始化邻接表
    public Graph(int numNodes) {
        adj = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    // 添加一条边，将节点v与节点w相连
    public void addEdge(int v, int w) {
        adj[v].add(w); // 将节点w加入节点v的邻接表中
    }

    // 从节点v开始进行深度优先遍历
    public void dfs(int v, boolean[] visited) {
        visited[v] = true; // 标记节点v已被访问
        System.out.print(v + " "); // 输出被访问的节点v
        for (int i = 0; i < adj[v].size(); i++) { // 遍历节点v的邻接表
            int n = adj[v].get(i); // 获取节点v的邻接节点n
            if (!visited[n]) { // 如果节点n未被访问，则以节点n为起点继续深度优先遍历
                dfs(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4); // 创建一个包含4个节点的图
        g.addEdge(0, 1); // 添加一条边，连接节点0和节点1
        g.addEdge(0, 2); // 添加一条边，连接节点0和节点2
        g.addEdge(1, 2); // 添加一条边，连接节点1和节点2
        g.addEdge(2, 0); // 添加一条边，连接节点2和节点0
        g.addEdge(2, 3); // 添加一条边，连接节点2和节点3
        g.addEdge(3, 3); // 添加一条边，连接节点3和节点3
        boolean[] visited = new boolean[4]; // 创建一个数组，用于记录每个节点是否被访问
        g.dfs(2, visited); // 从节点2开始进行深度优先遍历
    }
}

