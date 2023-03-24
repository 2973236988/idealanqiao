package Stack3;

import java.util.*;

/**
 * @Description:
 * @Class: EightQueen
 * @Package: Stack3
 * @Author: hedgeway
 * @CreateTime: 2023/3/4 11:46
 */
public class EightQueen {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EightQueen eightQueen  = new EightQueen();
        List<List<String>> lists = eightQueen.solveNQueens(8);

        for (int l = 0; l < lists.size(); l++) {
            List<String> queenList = lists.get(l);
            char[][] board = new char[8][8];

            for (int j = 0; j < 8; j++) {
                String row = queenList.get(j);
                for (int k = 0; k < 8; k++) {
                    board[j][k] = row.charAt(k);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println();
        System.out.println("程序用时：" + timeElapsed + "毫秒");
        System.out.println("总共有"+ lists.size()+"种情况");
    }

    public List<List<String>>  solveNQueens(int n){
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions,queens,n,0,columns,diagonals1,diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions,int[] queens,int n,int row,Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2){
        if (row == n){
            List<String> board = generateBoard(queens,n);
            solutions.add(board);
        }else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)){
                    continue;
                }

                int diagonal1 = row-i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }

                int diagonal2 = row+i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                backtrack(solutions,queens,n,row+1,columns,diagonals1,diagonals2);

                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens,int n){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


}
