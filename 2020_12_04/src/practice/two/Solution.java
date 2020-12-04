package practice.two;

import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    //构建乘积数组
    //创建B，把B中每个元素都设置为1
    //然后遍历A，如果遍历的下标是B当前需要乘的下标，那么不乘
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B,1);
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(j!=i){
                    B[j]*=A[i];
                }
            }
        }
        return B;
    }
}
