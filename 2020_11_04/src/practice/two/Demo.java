package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/4 10:13
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        double[] arr = new double[2];
        System.out.println(arr[0]);
        String str = "i love you";
//        System.out.println(reverse(str));
        int[][] twoArr = new int[][]{
                {1,2,3},
                {2,3,4},
                {4,5,6}
        };
        /*
        4,5,6,
        2,3,4
        1,2,3
         */
        int[][] ints = reverseRow(twoArr);
        for(int i=0;i<ints.length;i++){
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int[][] reverseRow(int[][] arr){
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            newArr[arr.length-1-i] = arr[i];
        }
        return newArr;
    }












    public static String reverse(String str){
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder(s[s.length-1]);
        for(int i=s.length-2;i>=0;i--){
            sb.append(" ").append(s[i]);
        }
        return sb.toString();
    }
}
