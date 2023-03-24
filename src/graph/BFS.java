package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Class: BFS
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/17 20:31
 */

public class BFS {

        // 定义节点类
        static class Node {
            int val;
            List<Node> neighbors;
            boolean visited;

            Node(int val) {
                this.val = val;
                this.neighbors = new ArrayList<>();
                this.visited = false;
            }
        }

        public static void bfs(Node start) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(start);
            start.visited = true;

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                System.out.print(curr.val + " ");

                for (Node neighbor : curr.neighbors) {
                    if (!neighbor.visited) {
                        neighbor.visited = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);

            node1.neighbors.add(node2);
            node1.neighbors.add(node3);
            node2.neighbors.add(node4);
            node3.neighbors.add(node4);
            node4.neighbors.add(node5);

            bfs(node1);
        }
    }


