package practice.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    /**
     * 贪心算法解决
     * 某餐馆有n张桌子，每张桌子有一个参数：a可容纳的最大人数
     * 有m批客人，每批客人有两个参数：b人数，c预计消费金额。
     * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得消费金额最大
     * 示例1:
     * 输入：3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
     * 输出：20
     * 3张桌子   桌子可坐人数 2 4 2
     * 5批客人
     * 客人人数和消费金额
     * 1:3
     * 3:5
     * 3:7
     * 5:9
     * 1:10
     */
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
        boolean[] tab = new boolean[table]; //代表桌子是否被占用
        long res = 0L;    //最后返回的结果
        int index = 0;    //桌子下标
        //从最贵的消费者开始，分配桌子，除非，桌子大小不够
        //桌子从小的开始分配
        for(int i=0;i<consumerNumAndMoney.length;i++){
            int dex = getIndex(tablePersonNum,consumerNumAndMoney[i][0]);
            //去判断当前桌子是否被占用，如果被占用，那么dex++
            while(dex<tablePersonNum.length&&tab[dex]){
                dex++;
            }
            //去判断dex是否合法，合法就用该桌子分配该客人，如果不合法
            //说明找不到合适的桌子给当前消费者
            if(dex<table){
                res+=consumerNumAndMoney[i][1];
                tab[dex] = true;
            }
        }
        System.out.println(res);
    }
    //通过consumer，二分查找找到tables升序中>=consumer的最接近的值
    public static int getIndex(int[] tables,int consumer){
        int left = 0;
        int right = tables.length-1;
        int mid = -1;
        while(left<=right){
            mid = (left+right)>>1;
            if(tables[mid]>=consumer){
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

