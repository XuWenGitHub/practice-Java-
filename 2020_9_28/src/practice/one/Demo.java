package practice.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/28 10:04
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
        //初始化数组和下标
        arr = new int[matrix.length*matrix[0].length];  //最后返回的数组
        index = 0;  //arr的下标
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];   //判断二维数组每个位置是否访问过
        arr[0] = matrix[0][0];     //给最后返回的数组赋值第一个数据
        isVisited[0][0]= true;  //设置该位置已经访问
        goMiGong(matrix,isVisited,0,0);

        return arr;
    }
    static int[] arr;   //返回的数组
    static int index;   //数组的下标

    //递归处理,要有一个boolean类型数组
    public static void goMiGong(int[][] matrix, boolean[][] isVisited, int i, int j) {

        //自己给定一个规则：右->下->左->上
        //因为每次该数到一个端点的时候，只能走一个方向
        //当给给定位置为（0,0）的时候，就会往右走，我们让其一直走，走到4的位置
        //然后再传入0,3这个位置，就是4这个位置，然后当传入0,3这个位置的时候，就只能往下走
        //每次都让其走到端点
        /*
        1  2  3  4
        5  6  7  8
        9  10 11 12
        13 14 15 16
         */
        if (((j + 1) < matrix[i].length && !isVisited[i][j + 1])) {  //判断是否能往右走
            //如果能往右走的话，那么就让其一直走，直到走不了位置，没走一个，加一个，且设置其访问过了
            while ((j + 1) < matrix[i].length && !isVisited[i][j + 1]) {
                index++;
                j++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }
            goMiGong(matrix, isVisited, i, j);  //再把这个位置递归下去
        } else if ((i + 1) < matrix.length && !isVisited[i + 1][j]) {   //往下走
            while ((i + 1) < matrix.length && !isVisited[i + 1][j]) {
                index++;
                i++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((j - 1) >= 0 && !isVisited[i][j - 1]) {  //往左走
            while ((j - 1) >= 0 && !isVisited[i][j - 1]) {
                index++;
                j--;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((i - 1) >= 0 && !isVisited[i - 1][j]) {  //往上走
            while ((i - 1) >= 0 && !isVisited[i - 1][j]) {
                index++;
                i--;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }
            goMiGong(matrix, isVisited, i, j);
        }

    }
}
