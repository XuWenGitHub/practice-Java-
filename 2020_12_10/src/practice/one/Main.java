package practice.one;

public class Main {
    public static void main(String[] args) {
        String s1 = args[1];
        String s2 = args[2];
        String s3 = args[3];
    }
    //两个数相加，不用加法
    public int addAB(int A, int B) {
        int res = A^B;    //目前不同位想加的值
        int carry = (A&B)<<1;    //需要进位的地方
        while(carry!=0){
            int t = res;    //保存目前res的值
            res = carry^res;    //让res和carry异或，拿到不用进位的值
            carry = (t&carry)<<1;    //再让carry变成t和carry按位与左移一位
        }
        return res;
    }
}
