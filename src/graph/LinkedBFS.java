package graph;

import java.util.*;

/**
 * @Description:
 * @Class: LinkedBFS
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/17 20:49
 */
public class LinkedBFS {
    public static void bfsTraversal(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>(); // 创建队列保存遍历到的节点
        Set<Integer> visited = new HashSet<>(); // 创建集合保存已经访问过的节点

        queue.offer(start); // 将起始节点添加到队列的末尾
        visited.add(start); // 标记起始节点为已经访问

        while (!queue.isEmpty()) {
            int curr = queue.poll(); // 取出队列头部元素进行处理
            System.out.print(curr + " ");

            // 遍历当前节点的所有相邻节点
            for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) { // 如果相邻节点未访问过
                    queue.offer(neighbor); // 将相邻节点添加到队列的末尾
                    visited.add(neighbor); // 标记相邻节点为已经访问
                }
            }
        }
    }

    public static void main(String[] args) {
        // 示例用法
        Map<Integer, List<Integer>> graph = new HashMap<>(); // 创建一个图，使用邻接表表示
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList(3));

        LinkedBFS.bfsTraversal(graph, 2); // 从节点 2 开始进行 BFS 遍历
    }
}
