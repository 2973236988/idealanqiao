package lanqiao;

import sun.font.FontRunIterator;
import sun.security.util.Length;

import java.util.logging.Level;
import java.util.logging.XMLFormatter;

/**
 * @Description:
 * @Class: number
 * @Package: lanqiao
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 21:07
 */
public class number {
    int[] numbers =new int[]{99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11, 18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77};
    int xcount = 0;
    int bigcount = 0;

    public int count(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                xcount +=1;
                if (nums[i] * nums[j] >= 2022){
                    bigcount += 1;
                }
            }
        }
        return bigcount;
    }

    public static void main(String[] args) {
        number number = new number();
        int count = number.count(number.numbers);
        System.out.println(count);//189
        System.out.println();
        System.out.println(number.xcount);//435
    }

}
