package lanqiao;

import java.util.Scanner;

/**
 * @Description:
 * @Class: SignalTower
 * @Package: lanqiao
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 22:20
 */
public class SignalTower {


    public static void main(String[] args) {
        int W,H,n,R;
        int[][] p = new int[105][2];
        boolean[][] st = new boolean[105][105];
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        
        W = scanner.nextInt();
        H = scanner.nextInt();
        n = scanner.nextInt();
        R = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[] arr = new int[]{x,y};
            p[i] = arr;
            st[x][y] = true;
        }

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < n; k++) {
                    if (st[i][j]){
                        break;
                    }
                    double dist = Math.sqrt(Math.abs(p[k][0] - i) * Math.abs(p[k][0] - i) + Math.abs(p[k][1] - j) * Math.abs(p[k][1] - j) );
                    if (dist <R ){
                        st[i][j] = true;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i <= W; i ++){
            for(int j = 0; j <= H; j ++)
            {
                if(st[i][j]) {
                    res ++;
                }
            }
        }

        System.out.println(res);

    }
}
