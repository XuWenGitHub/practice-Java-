import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();   //代表蜡烛长度为ncm
//        method(n);
        System.out.println(minute(6));
        method(6);
    }

    public static void method(int n) {
        double res = 0; //分子,n-1种组合，每次需要多少时间
        double[] dp = dp(n);
        for (int i = 1; i <= n - 1; i++) {
            int lazhu1 = i;
            int lazhu2 = n - i;
            if (lazhu1 < lazhu2) {
                res += lazhu1;
                res += dp[(lazhu2 - lazhu1)];
            } else if (lazhu1 > lazhu2) {
                res += lazhu2;
                res += dp[(lazhu1 - lazhu2)];
            } else {
                res += lazhu1;
            }
        }
        if (n != 1) {
            System.out.println(res / (n - 1));
        } else {
            System.out.println(1);
        }
    }

    public static double[] dp(int n) {
        double[] dp = new double[n + 1];  //代表ncm，只分一次，需要多久时间
        for (int i = 1; i <= n; i++) {
            dp[i] = minute(i);
        }
        return dp;
    }

    //n cm长度的蜡烛，只能分一次，需要燃烧多久
    public static double minute(int n) {
        if (n == 1) {
            return 1;
        }
        double res = 0; //分子，分母为n-1
        for (int i = 1; i <= n - 1; i++) {
            res += Math.max(n - i, i);
        }
        return res / (n - 1);
    }
    /*
一根长度为n厘米的蜡烛，每分钟可以燃烧1厘米
第一次把一根蜡烛分成两根蜡烛，有n-1个可以分的位置
两根蜡烛点燃，当一根燃完，另外一个根长度>=2时
那么我们还必须对剩下的这根蜡烛进行重复操作（随机分开，再点燃）
文所有蜡烛全部烧完的期望时间（分钟数）
4cm的蜡烛，可以分成1cm和3cm 2cm和2cm 3cm和1cm
1cm和3cm，1cm烧完，还剩下一个2cm，然后一分，1cm和1cm，烧1cm。共2分钟
2cm和2cm  2cm烧完，需要2分钟

算出蜡烛，只能分一次，需要多久时间
1cm的蜡烛  1分钟
2cm的蜡烛  1分钟
3cm的蜡烛  2分钟
4cm的蜡烛  5/2分钟
5cm的蜡烛  7/2分钟   (4+
6cm的蜡烛  >1+5  2+4  3+3  4+2  5+1     (5+4+3+4+5)/5
*/
}
