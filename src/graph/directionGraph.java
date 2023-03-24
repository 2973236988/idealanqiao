package graph;

/**
 * @Description:
 * @Class: directionGraph
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/13 21:13
 */
public class directionGraph {
    public static void main(String[] args) {
        int [][] data = {{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},{5,3},{4,5},{5,4}};

        int arr[][] = new int[6][6];
        int i, j,k,tempi,tempj;

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                arr[i][j] = 0;
            }
        }

        for (i = 0; i < 14; i++) {
            for (j = 0; j < 6; j++) {
                for (k = 0; k < 6; k++) {
                    tempi = data[i][0];
                    tempj = data[i][1];
                    arr[tempi][tempj] = 1;
                }
            }
        }
        System.out.print("无向图形矩阵：\n");
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }

    }
}
