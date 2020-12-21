package practice.one;

import java.util.Arrays;

//颜色填充
public class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] ints = floodFill(arr, 1, 1, 2);
        for(int[] a:ints){
            System.out.println(Arrays.toString(a));
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        flag = new boolean[image.length][image[0].length];
        flood(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    static boolean[][] flag;
    public static void flood(int[][] image,int row,int lie,int color,int newColor){
        //代表下标越界
        if(row<0||row>=image.length||lie<0||lie>=image[row].length){
            return;
        }
        if(image[row][lie]==color&&!flag[row][lie]){
            image[row][lie] = newColor;
            flag[row][lie] = true;
            flood(image,row-1,lie,color,newColor);  //上
            flood(image,row+1,lie,color,newColor);  //上
            flood(image,row,lie-1,color,newColor);  //上
            flood(image,row,lie+1,color,newColor);  //上
        }
    }
}