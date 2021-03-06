package practice.two;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] doubles = solution.dicesProbability(2);
        System.out.println(Arrays.toString(doubles));
        double a = 1.0;
        double b = Math.pow(6,1);
        double c = a/b;
        System.out.println(c);
    }
    static class Solution {
        public double[] dicesProbability(int n) {
            double[][] dp = new double[n+1][n*6+1];
            for(double i=1;i<=6;i++){
                dp[1][(int)i] = 1.0/6.0;
            }
            for(double i=2;i<=n;i++){
                double sum = 0;
                for(double j=i;j<=i*6;){
                    double left = j;
                    double right = i*6;
                    while(left<=right){
//                        if(left==j){
//                            sum+=dp[(int)i-1][(int)left-1];
//                            dp[(int)i][(int)left] = sum*(1.0/6.0);
//                            dp[(int)i][(int)right] = dp[(int)i][left];
//                            left++;
//                            right--;
//                            continue;
//                        }
                        sum+=dp[(int)i-1][(int)left-1];
                        dp[(int)i][(int)left] = sum*(1.0/6.0);
                        dp[(int)i][(int)right] = dp[(int)i][(int)left];
                        left++;
                        right--;
                    }
                    break;
                }
            }

            double[] res = new double[n*6-n+1];
            int index = 0;
            for(int i=n;i<n*6+1;i++){
                res[index++] = dp[n][i];
            }
            return res;
        }
    }
}
