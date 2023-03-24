package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @Class: StackGraph
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/17 14:23
 */
public class StackGraph {
    // 图的节点数
    private int numOfVertices;

    // 用邻接表表示图
    private ArrayList<LinkedList<Integer>> adjacencyList;

    // DFS算法的构造函数
    public StackGraph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjacencyList = new ArrayList<>();

        // 初始化邻接表
        for (int i = 0; i < numOfVertices; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
    }

    // 添加一条边
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    // DFS遍历
    public void DFS(int startVertex) {

        // 标记所有节点为未访问
        boolean[] visited = new boolean[numOfVertices];

        // 用栈保存要访问的节点
        Stack<Integer> stack = new Stack<>();

        // 将起始节点压入栈中
        stack.push(startVertex);

        while (!stack.empty()) {

            // 弹出栈顶节点
            int currentVertex = stack.pop();

            // 如果当前节点没有被访问过
            if (!visited[currentVertex]) {

                // 标记当前节点为已访问
                visited[currentVertex] = true;
                System.out.print(currentVertex + " ");

                // 将当前节点的所有未访问的邻居压入栈中
                LinkedList<Integer> neighbors = adjacencyList.get(currentVertex);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        StackGraph graph = new StackGraph(6);

        // 添加边
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.print("DFS遍历的结果是：");
        graph.DFS(0);
    }
}



