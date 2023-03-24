package lanqiao;

/**
 * @Description:
 * @Class: main
 * @Package: demo
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 20:42
 */
public class Main {
    int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int get(int x){
        int res = 0;
        boolean flag =true;
        while (flag){
            res += x %10;
            x /= 10;
            if (x > 0){
                flag = true;
            }else {
                flag = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int ans = 0;
        for(int i = 1900; i <= 9999; i ++) {
            int syear = main.get(i);
            boolean is_leap;
            if (i%400 == 0 || (i%100 >0 && i%4 ==0)){
                is_leap = true;
            }else {
                is_leap = false;
            }

            for(int j = 1; j <= 12; j ++) {
                if(j == 2 && is_leap) {
                    main.month[2] = 29;
                } else {
                    main.month[2] = 28;
                }
                for(int k = 1; k <= main.month[j]; k ++)
                {
                    int smd = main.get(j) + main.get(k);
                    if(smd == syear) {
                        ans ++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
