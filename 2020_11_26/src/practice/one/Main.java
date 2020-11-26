package practice.one;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //贪心算法，先一直用8个袋子的装
        //剩余的一定(0-7)，如果>=6，再6个一装，再看剩余
        int pack = n/8;    //8个袋子的数量
        int elePack = n/8;    //8个袋子的数量
        int res = n%8;    //剩余的苹果
        if(res>=6){    //如果剩余>=6，再来一个6个装
            res-=6;
            pack+=1;
        }
        //因为现在剩余的肯定是0-5,前面一直8个装，剩余的，只能从8个装的情况下去凑，凑够6个
        //凑不够，那肯定就不能恰好n个苹果了
        if(res%2==0){
            if(res==0){
                System.out.println(pack);
                return;
            }
            int sub = (6-res)/2;//需要多个8个装袋子去转换成6个装的袋子填补
            if(elePack>=sub){
                pack++;
                elePack-=sub;
                System.out.println(pack);
            }else{
                System.out.println(-1);
            }
        }else{
            System.out.println(-1);
        }
    }
}