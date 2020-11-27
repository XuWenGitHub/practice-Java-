package practice.two;

import java.util.Scanner;
public class Main {
    public static final int WEIGHT = 40;    //代表总重量
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //代表一共有多少种不同重量的物品
        int[] weight = new int[n];  //代表每种物品的重量
        //给每种物品录取重量
        for(int i=0;i<n;i++){
            weight[i] = sc.nextInt();
        }
        System.out.println(pack(weight,0,WEIGHT));
    }

    /**
     * 递归实现神奇的口袋
     * @param wight 所有物品重量的数组
     * @param index 表示当前物品在数组的下标
     * @param res   代表剩余
     * @return  返回有多少种不同的装法
     */
    public static int pack(int[] wight,int index,int res){
        if(res==0){
            return 1;
        }
        if(index>=wight.length||res<0){
            return 0;
        }
        //两种情况，当前下标的物品，装或者不装
        return pack(wight,index+1,res-wight[index])+pack(wight,index+1,res);
    }
}
