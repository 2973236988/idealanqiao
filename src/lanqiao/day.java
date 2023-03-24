package lanqiao;

import java.util.Scanner;

/**
 * @Description:
 * @Class: day
 * @Package: lanqiao
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 21:44
 */
public class day {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentday = scanner.nextInt();
        int nday = scanner.nextInt();
        currentday %= 7;
        nday += currentday;
        nday %= 7;
        System.out.println(nday == 0 ? 7: nday);
    }
}
