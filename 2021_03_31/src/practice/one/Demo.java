package practice.one;

public class Demo {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(14));
        String s = "asda";

    }
    public static int numberOfMatches(int n) {
        if(n==2){
            return 1;
        }
        int num = n/2;  //代表匹配次数
        if(n%2==1){ //奇数
            return num+numberOfMatches(num+1);
        }else{  //偶数
            return num+numberOfMatches(num);
        }
    }
}
