package graph9;

import java.util.*;

public class FloydAlgorithm {

    public void floydWithPath(int[][] graph) {
        int n = graph.length;

        int[][] dist = new int[n][n];
        List<Integer>[][] path = new List[n][n];

        // 初始化距离矩阵和路径矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    dist[i][j] = graph[i][j];
                    path[i][j] = new ArrayList<>();
                    path[i][j].add(i);
                    path[i][j].add(j);
                }
            }
        }

        // 枚举所有中间点，更新距离矩阵和路径矩阵
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                        // 更新路径矩阵
                        List<Integer> newPath = new ArrayList<>(path[i][k]);
                        newPath.remove(newPath.size() - 1);
                        newPath.addAll(path[k][j]);
                        path[i][j] = newPath;
                    }
                }
            }
        }

        // 打印结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Shortest path from " + i + " to " + j + ": ");
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.println("Does not exist");
                } else {
                    System.out.print(i);
                    for (int node : path[i][j]) {
                        System.out.print(" -> " + node);
                    }
                    System.out.println("; distance = " + dist[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 3},
                {0, 0, 1, 4},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        };
        FloydAlgorithm fa = new FloydAlgorithm();
        fa.floydWithPath(graph);
    }
}

/**

 by chatgpt
 Shortest path from 0 to 0: Does not exist
 Shortest path from 0 to 1: 0 -> 0 -> 1; distance = 2
 Shortest path from 0 to 2: 0 -> 0 -> 1 -> 2; distance = 3
 Shortest path from 0 to 3: 0 -> 0 -> 3; distance = 3
 Shortest path from 1 to 0: Does not exist
 Shortest path from 1 to 1: Does not exist
 Shortest path from 1 to 2: 1 -> 1 -> 2; distance = 1
 Shortest path from 1 to 3: 1 -> 1 -> 2 -> 3; distance = 3
 Shortest path from 2 to 0: Does not exist
 Shortest path from 2 to 1: Does not exist
 Shortest path from 2 to 2: Does not exist
 Shortest path from 2 to 3: 2 -> 2 -> 3; distance = 2
 Shortest path from 3 to 0: Does not exist
 Shortest path from 3 to 1: Does not exist
 Shortest path from 3 to 2: Does not exist
 Shortest path from 3 to 3: Does not exist

 进程已结束，退出代码为 0

 */