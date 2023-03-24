package graph;

/**
 * @Description:
 * @Class: undirectionGraph
 * @Package: graph
 * @Author: hedgeway
 * @CreateTime: 2023/3/13 21:20
 */
public class undirectionGraph {
    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        int i,j,tmpi,tmpj;
        int [][] data = {{1,2},{2,1},{2,3},{2,4},{4,3}};
        for ( i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                arr[i][j]  = 0;
            }
        }

        for ( i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                tmpi = data[i][0];
                tmpj = data[i][0];
                arr[tmpi][tmpj] = 1;
            }
        }
        System.out.print("有向图形矩阵：\n");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }

    }
}
