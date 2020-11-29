package practice.one;
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int[] arr = new int[split.length];
        int index = 0;
        for(String s:split){
            arr[index++] = Integer.parseInt(s);
        }
        System.out.println(getMaxNum(arr));
    }
    public static int getMaxNum(int[] arr){
        if(arr==null||arr.length==0){
            return -1;
        }
        int res = arr[0];
        int num = 1;
        for(int i=1;i<arr.length;i++){
            if(num!=0){
                if(arr[i]==res){
                    num++;
                }else{
                    num--;
                }
            }else{
                res = arr[i];
                num=1;
            }
        }
        return res;
    }
}