package graph;

/**
 * @Description:
 * @Class: MatrixGraph
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/17 14:11
 */
class MatrixGraph {
    private int[][] maze; // 迷宫矩阵
    private boolean[][] visited; // 是否访问过
    private int startX, startY; // 起点坐标
    private int endX, endY; // 终点坐标
    private int row, col; // 迷宫行数和列数

    public MatrixGraph(int[][] maze, int startX, int startY, int endX, int endY) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.row = maze.length;
        this.col = maze[0].length;
    }

    // DFS算法实现，返回是否找到终点
    public boolean dfs(int x, int y) {
        // 如果当前位置已经访问过或者是墙，直接返回false
        if (visited[x][y] || maze[x][y] == 1) {
            return false;
        }

        // 如果找到了终点，返回true
        if (x == endX && y == endY) {
            return true;
        }

        // 标记当前位置已经访问过
        visited[x][y] = true;

        // 上下左右四个方向依次递归搜索
        if (x > 0 && dfs(x - 1, y)) {
            return true;
        }
        if (y > 0 && dfs(x, y - 1)) {
            return true;
        }
        if (x < row - 1 && dfs(x + 1, y)) {
            return true;
        }
        if (y < col - 1 && dfs(x, y + 1)) {
            return true;
        }

        // 如果四个方向都没有找到终点，回溯并返回false
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        // 初始化迷宫矩阵
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 0}
        };

        // 初始化起点和终点坐标
        int startX = 0, startY = 0, endX = 3, endY = 3;

        // 创建DFS对象并执行搜索
        MatrixGraph dfs = new MatrixGraph(maze, startX, startY, endX, endY);
        boolean found = dfs.dfs(startX, startY);

        // 输出结果
        if (found) {
            System.out.println("找到了一条从起点到终点的路径");
        } else {
            System.out.println("没有找到从起点到终点的路径");
        }
    }
}
