package practice.two;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        arr = new int[matrix.length*matrix[0].length];  //最后返回的数组
        index = 0;
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        arr[0] = matrix[0][0];
        isVisited[0][0]= true;
        goMiGong(matrix,isVisited,0,0);

        return arr;
    }
    static int[] arr;   //返回的数组
    static int index;   //数组的下标

    //递归处理,要有一个boolean类型数组
    public void goMiGong(int[][] matrix, boolean[][] isVisited, int i, int j) {
        //右->下->左->上
        if (((j + 1) < matrix[i].length && !isVisited[i][j + 1])) {   //上
            while ((j + 1) < matrix[i].length && !isVisited[i][j + 1]) {
                index++;
                j++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }
            goMiGong(matrix, isVisited, i, j);
        } else if ((i + 1) < matrix.length && !isVisited[i + 1][j]) {
            while ((i + 1) < matrix.length && !isVisited[i + 1][j]) {
                index++;
                i++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((j - 1) >= 0 && !isVisited[i][j - 1]) {
            while ((j - 1) >= 0 && !isVisited[i][j - 1]) {
                index++;
                j--;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((i - 1) >= 0 && !isVisited[i - 1][j]) {
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
