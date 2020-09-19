package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/18 15:24
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0,0,8,5,4}));
        Queue<Integer> queue  =new ArrayDeque<>();

        System.out.println(lastRemaining(9,13));
    }
    //n就表示人数，m表示第几个开始出队列
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while(n>1){
            index = (index+m-1)%n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
    //不用加减乘数，算两个数的和
    public int add(int a, int b) {
        int digit = (a&b)<<1;   //表示a和b的进位
        int ab = a^b;   //表示a和b除了进位的数
        while(digit!=0){
            int temp = ab;  //先保存ab，好让进位更改
            ab = ab^digit;
            digit = (digit&temp)<<1;
        }
        return ab;
    }

    /*
       从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

   输入: [1,2,3,4,5]
   输出: True
       */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0; //表示0的个数
        int i=0;
        int prev=-1;    //上一个数
        while(i<nums.length){
            if(nums[i]==0){ //表示有大小王
                zeroNum++;
                //prev=0;
                i++;
                continue;
            }

            if(prev!=-1){   //表示不是第一个确定的牌
                int sub = nums[i]-prev; //因为排序，和前一张牌找差值，如果为1说明OK，如果>1，那么就要用大小王来填空缺，直至填到差值为1
                if(sub!=1){ //需要用大小王补
                    while(sub!=1){  //直至补成1
                        zeroNum--;
                        sub--;
                        if(zeroNum<0){  //如果大小王个数变成-1，那么说明，不是顺子
                            return false;
                        }
                    }
                }
            }
            prev=nums[i];   //记录前驱
            i++;    //下标增加
        }
        return true;
    }
}
