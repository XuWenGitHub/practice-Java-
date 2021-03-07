package practice.five;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int table = sc.nextInt();
        int consumer = sc.nextInt();
        int[] tablePersonNum = new int[table];
        for (int i = 0; i < table; i++) {
            tablePersonNum[i] = sc.nextInt();
        }
        int[][] consumerNumAndMoney = new int[consumer][2];
        for (int i = 0; i < consumer; i++) {
            consumerNumAndMoney[i][0] = sc.nextInt();
            consumerNumAndMoney[i][1] = sc.nextInt();
        }
        foodTable(table,consumer,tablePersonNum,consumerNumAndMoney);
    }
    public static void foodTable(int table,int consumer,int[] tablePersonNum,int[][] consumerNumAndMoney){
        Arrays.sort(tablePersonNum);    //升序，从小桌子-》大桌子
        Arrays.sort(consumerNumAndMoney, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        }); //按照价钱降序排序
        //boolean[] tab = new boolean[table]; //代表桌子是否被占用
        boolean[] consumers = new boolean[consumer];
        long res = 0L;
        for (int j = 0; j < table; j++) {   //j代表用第j个桌子
            for(int i=0;i<consumer;i++){    //i代表第i波消费者
                if(consumers[i]||consumerNumAndMoney[i][0]>tablePersonNum[j]){
                    continue;
                }
                res+=consumerNumAndMoney[i][1];
                consumers[i] = true;    //代表这波客人被用掉
                break;
            }
        }
        System.out.println(res);
    }
}
