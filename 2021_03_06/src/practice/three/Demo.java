package practice.three;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Demo {
    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][n * 6 + 1];
        //i横坐标代表带塞子的个数
        //j代表当前需要凑的点数
        //如果有2个塞子，那么第二个塞子，如果点数是2的话，最后一个塞子是1的话，那么我需要上一个塞子点数是1。如果点数和是4的话，那么最后一个塞子如果是1,2,3：那么上一个塞子一定是3,2,1的概率和，但是如果上一个塞子是3,2,1，那么最后一个塞子一定是1,2,3,。那么就需要一个塞子是1、2、3的概率和。因为确定的前面的塞子，最后一颗塞子一定是确定的。画图，即可
            /*
            塞子的点数和  1 2 3 4 5 6  7  8  9  10 11 12 13 14 15
            塞子的个数
            1            1 1 1 1 1 1
            2              1 2 3 4 5  6  5  4  3  2  1
            3                1 3 6 10 15 21 25 27
            每个二维数组的值/Math.pow(6,塞子的个数)
            */
        //dp[i][j]=代表i个塞子，摇到j的概率
        //第一个，一定是1
        //从第二个开始，每次加上当前行前面的，并且加上上一行，上一列的
        //如果个数够6个了，那么就要减去deque.removeFirst()
        //最后一个塞子，只可能是1-6,6种可能，所以求出前面点数和，塞子个数-1的概率即可
        Deque<Double> deque = new LinkedList<>();//从尾巴进，从头出，最多只留6个
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0;
        }
        for (int i = 2; i <= n; i++) {
            deque.clear();
            int left = i;
            int right = i * 6;
            dp[i][left++] = 1.0;
            dp[i][right--] = 1.0;
            deque.addLast(1.0);
            while (left <= right) {
                if (deque.size() != 6) {
                    deque.addLast(dp[i - 1][left - 1]);
                    dp[i][left] = dp[i][left - 1] + dp[i - 1][left - 1];
                } else {
                    deque.addLast(dp[i - 1][left - 1]);
                    dp[i][left] = dp[i][left - 1] + dp[i - 1][left - 1] - deque.removeFirst();
                }
                dp[i][right] = dp[i][left];
                left++;
                right--;
            }
        }
        double[] res = new double[n * 6 - n + 1];
        int index = 0;
        for (int i = n; i < n * 6 + 1; i++) {
            res[index++] = dp[n][i] / Math.pow(6, n);
        }
        return res;
    }
}