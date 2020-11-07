package practice.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/6 23:41
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
        HashSet[] row = new HashSet[9];

    }
    //比较字符串最小字母出现频次
    //1.先用一个数组来保存，words数组中每个字符串自动f(str)和的个数
    //2.再更新数组，arr[i] += arr[i+1],要从后，往前遍历,这样就算出来小于等于当前值的个数
    //3.直接遍历qureies数组中，每一个字符串，拿到每个字符串的f(str)的值，然后拿到值之后，然后去arr里面找>当前值的个数，就是拿到的值下标+1c处
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //用来保存words中出现字符串s中最小字母出现的次数的个数
        int[] arr = new int[12];
        for(String str:words){
            arr[counts(str)]++;
        }
        //然后更新一个arr，来表示，大于等于每个最小字母出现的次数的个数和
        for(int i=9;i>=0;i--){
            arr[i]+=arr[i+1];
        }
        //最后去判断queries中每个单词再words里面f(queries[i]) < f(W)个数
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i] = arr[counts(queries[i])+1];
        }
        return res;
    }
    //counts方法用于统计字符串s中最小字母出现的次数
    private int counts(String s){
        char ch = s.charAt(0);
        int num = 1;
        for(int i=1;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp==ch){
                num++;
            }else if(temp<ch){
                ch = temp;
                num=1;
            }
        }
        return num;
    }

    //无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        //1.用一个map保存每个字符->下标+1
        //为了下次遇到相同的，就可以直接把start移动到该位置
        Map<Character,Integer> charToIndex = new HashMap<>();
        int len = 0;
        for(int start=0,end=0;end<s.length();end++){
            char ch = s.charAt(end);
            if(charToIndex.containsKey(ch)){
                start = Math.max(charToIndex.get(ch),start);
            }
            len = Math.max(len,end-start+1);
            charToIndex.put(ch,end+1);
        }
        return len;
    }

    private final int N = 9;
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> [] rows = new HashSet[N];
        HashSet<Integer> [] cols = new HashSet[N];
        HashSet<Integer> [] boxes = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j  = 0; j < N; j++) {
                if (board[i][j] == '.')
                    continue;
                int tmp = board[i][j] - '0';
                if (rows[i].contains(tmp) //本行中已有数字
                        || cols[j].contains(tmp) //本列中已有数字
                        || boxes[(i / 3) * 3 + j / 3].contains(tmp)) //本方格中已有数字
                    return false;
                rows[i].add(tmp); //添加到本行
                cols[j].add(tmp); //添加到本列
                boxes[(i / 3) * 3 + j / 3].add(tmp); //添加到本方格
            }
        }
        return true;
    }

    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    //用哈希表，维持一个移动窗口
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

}
