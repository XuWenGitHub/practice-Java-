package practice.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/27 11:25
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[] res = spiralOrder(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        goMiGong(list,matrix,isVisited,0,0);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    //递归处理,要有一个boolean类型数组
    public static void goMiGong(List<Integer> list,int[][] matrix,boolean[][] isVisited,int i,int j){
        if(isVisited[i][j]){
            return;
        }else{
            list.add(matrix[i][j]);
            isVisited[i][j]=true;
            //上->右->下->左

            if(((j+1)<matrix[i].length&&!isVisited[i][j+1])){
                goMiGong(list,matrix,isVisited,i,j+1);
            }else if((i+1)<matrix.length&&!isVisited[i+1][j]){
                goMiGong(list,matrix,isVisited,i+1,j);
            }else if((j-1)>=0&&!isVisited[i][j-1]){
                goMiGong(list,matrix,isVisited,i,j-1);
            }else if((i-1)>=0&&!isVisited[i-1][j]){
                goMiGong(list,matrix,isVisited,i-1,j);
            }
        }
    }
}
