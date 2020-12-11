package practice.two;

import java.util.*;

public class Main {
    //火车进站
    //1.先求出所有可能的出栈序列（不一定合法）
    //2.判断出栈序列是否合法
    //3.对合法的出栈序列进行排序后输出
    private static List<int[]> list =  new ArrayList<>();
    private static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            backTrece(n,arr,0);
            for(int[] t:list){
                if(isLegal(arr,t,n)) {
                    String s = arrToStr(t, n);
                    res.add(s);
                }
            }
            Collections.sort(res);
            for(String s:res){
                System.out.println(s);
            }
        }
    }

    //数组编程字符串，方便最后结果按字典序进行排序
    private static String arrToStr(int[] t,int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(t[i]);
            if(i!=n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //判断出栈序列是否合法
    private static boolean isLegal(int[] in,int[] out,int n){
        Deque<Integer> stack = new LinkedList<>();
        int j=0;
        for(int i=0;i<n;i++){
            stack.push(in[i]);
            while(j<n&&!stack.isEmpty()&&out[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    //求解所有可能出栈序列（不一定合法）
    private static void backTrece(int n,int[] arr,int beginIndex){
        if(beginIndex==n-1){
            int[] temp = arr.clone();
            list.add(temp);
            return;
        }
        for(int i=beginIndex;i<n;i++){
            swap(arr,i,beginIndex);
            backTrece(n,arr,beginIndex+1);
            swap(arr,i,beginIndex);
        }
    }
    private static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
