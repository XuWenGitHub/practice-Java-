package practice.one;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        System.out.println(method(new int[row][col],row,col));
    }

    public static int method(int[][] arr,int row,int col){
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(method(arr,i,j,row,col)){
                    arr[i][j]=1;
                    res++;
                }
            }
        }
        return res;
    }
    //判断当前位置是否可以添加
    public static boolean method(int[][] arr,int r,int c,int row,int col){
        //判断[r,c]的四个45度斜角不能放，说明这个位置就能放，或者45斜角越界
        if(c-2>=0&&arr[r][c-2]==1){//左上角
            return false;    //代表[r,c]这个位置不能放
        }
        if(c+2<col&&arr[r][c+2]==1){//右上角
            return false;
        }
        if(r-2>=0&&arr[r-2][c]==1){    //左下角
            return false;
        }
        if(r+2<row&&arr[r+2][c]==1){    //右下角
            return false;
        }
        return true;
    }
}