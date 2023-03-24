package graph2;
import java.util.Arrays;
import java.util.Comparator;

// 定义一个边类
class Edge {
    int start; // 边的起点
    int end; // 边的终点
    int weight; // 边的权值

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

// 定义一个图类
class Graph {
    int vertexNum; // 顶点个数
    int edgeNum; // 边个数
    Edge[] edges; // 存储所有边的数组

    public Graph(int vertexNum, int edgeNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        edges = new Edge[edgeNum];
    }
}

// 定义一个并查集类，用于判断两个顶点是否在同一棵树中
class UnionFind {
    int[] parent; // 存储每个顶点的父节点

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1; // 初始时每个顶点都是独立的树，用-1表示
        }
    }

    // 查找某个顶点所在树的根节点，并进行路径压缩
//        public int find(int x) {
//            if (parent[x] < 0) { // 如果x是根节点，直接返回x
//                return x;
//            } else { // 否则递归查找x的父节点，并将x直接指向其祖先节点，实现路径压缩
//                parent[x] = find(parent[x]);
//                return parent[x];
//            }
//        }

    public int find(int x){
        while(parent[x] >= 0){
            x = parent[x];
        }
        return x;
    }

    // 合并两个顶点所在的树，如果已经在同一棵树中，则不合并
//    public void union(int x, int y) {
//        int rootX = find(x); // 查找x所在树的根节点
//        int rootY = find(y); // 查找y所在树的跟节点
//        if (rootX != rootY) { // 如果不相等，说明不在同一棵树中，需要合并
////            if (parent[rootX] > parent[rootY]) {
////                parent[rootY] += parent[rootX];
////                parent[rootX] = rootY;
////            } else {
////                parent[rootX] += parent[rootY];
////                parent[rootY] = rootX;
////            }
//            parent[rootX] = rootY;
//        }
//    }
}

// 定义一个比较器类，用于对边按照权值进行排序
class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }

}


// 定义一个克鲁斯卡尔算法类
public class Kruskal {

    // 对图中的边进行排序，并返回最小生成树的权值之和
    public static int kruskal(Graph graph) {
        int sum = 0; // 存储最小生成树的权值之和
        Arrays.sort(graph.edges, new EdgeComparator()); // 对边按照权值从小到大排序
        UnionFind uf = new UnionFind(graph.vertexNum); // 创建一个并查集对象，用于判断两个顶点是否在同一棵树中
        for (int i = 0; i < graph.edgeNum; i++) { // 遍历所有的边
            Edge edge = graph.edges[i]; // 取出一条边
            int start = edge.start; // 边的起点
            int end = edge.end; // 边的终点
            int X = uf.find(start);
            int Y = uf.find(end);
            if (X != Y) { // 如果起点和终点不在同一棵树中，说明该边可以加入到最小生成树中，且不会形成回路
                sum += edge.weight; // 累加该边的权值到总和中
//              uf.union(start, end); // 合并起点和终点所在的树，使它们属于同一棵树
                uf.parent[X] = uf.find(Y);
                System.out.println("连接顶点" + start + "和顶点" + end + "，权值为" + edge.weight); // 打印该边的信息
            }
        }
        return sum; // 返回最小生成树的权值之和
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7, 12); // 创建一个有7个顶点，12条边的图对象

        graph.edges[0] = new Edge(4, 5, 35);
        graph.edges[1] = new Edge(4, 6, 28);
        graph.edges[2] = new Edge(5, 6, 34);
        graph.edges[3] = new Edge(0, 1, 7);
        graph.edges[4] = new Edge(1, 2, 8);
        graph.edges[5] = new Edge(0, 3, 5);
        graph.edges[6] = new Edge(1, 3 ,9);
        graph.edges[7] = new Edge(2 ,3 ,7);
        graph.edges[8] = new Edge(1 ,4 ,15);
        graph.edges[9] = new Edge(2 ,5 ,6);
        graph.edges[10] = new Edge(3 ,4 ,16);
        graph.edges[11] = new Edge(3 ,5 ,14);


        int sumWeight=kruskal(graph);
        System.out.println("最小生成树的总权值为:"+sumWeight);

    }
}