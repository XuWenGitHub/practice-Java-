
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //切的次数
        int[][] arr = new int[num][2];
        for(int i=0;i<num;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        //每次竖着切，res*2
        //横着切，多两个
        System.out.println(cat(arr));
    }
    public static int cat(int[][] arr){
        int res = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==1){   //竖着切
                res*=2;
            }else{
                res+=2;
            }
        }
        return res;
    }


//    public static void main(String[] args) {
//        //不同糖果的甜度可能相同，
//        //并且有些糖果味道可能很差，其甜度为零甚至是负值
//        Scanner sc = new Scanner(System.in);
//        int tuan = sc.nextInt();
//        int mei = sc.nextInt();
//        int[] tuanArr = new int[tuan];
//        int[] meiArr = new int[mei];
//        for(int i=0;i<tuan;i++){
//            tuanArr[i] = sc.nextInt();
//        }
//        for(int i=0;i<mei;i++){
//            meiArr[i] = sc.nextInt();
//        }
//        System.out.println(dp(meiArr)+dp(tuanArr));
//    }
//    //求两个dp,并且，当前老师的最大甜度
//    public static int dp(int[] arr){
//        //dp[i]包含我当前这一颗，最大甜度
//        int[] dp = new int[arr.length];
//        int res = 0;
//        for(int i=0;i<arr.length;i++){
//            if(i==0){
//                dp[i] = arr[i];
//            }else{
//                dp[i] = arr[i]+dp[i-1];
//            }
//            if(dp[i]>res){
//                res = dp[i];
//            }
//        }
//        return res;
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[][] arr = new int[n][n];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        NUM = k;
//        set = new TreeSet<>((o1,o2)->{
//            return o2-o1;
//        });
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                dfs(arr,i,j,1,0);
//            }
//        }
//
//        if(set.size()==0){
//            System.out.println(-1);
//        }else{
//            for(Integer s:set){
//                System.out.println(s);
//                return;
//            }
//        }
//    }
//    static int NUM = 0;
//    static Set<Integer> set ;
//    //k表示当前需要跳哪一步，money表示需要多少花费
//    public static void dfs(int[][] arr,int i,int j,int k,int money){
//        if(i<0||i>=arr.length||j<0||j>=arr.length||arr[i][j]!=k){
//            return; //表示不满足
//        }
//        if(k==NUM){ //表示已经到终点了
//            set.add(money);
//            return;
//        }
//        dfs(arr,i+1,j,k+1,money+getMoney(i,j,i+1,j));
//        dfs(arr,i,j+1,k+1,money+getMoney(i,j,i,j+1));
//        dfs(arr,i-1,j,k+1,money+getMoney(i,j,i-1,j));
//        dfs(arr,i,j-1,k+1,money+getMoney(i,j,i,j-1));
//    }
//
//    public static int getMoney(int x1,int y1,int x2,int y2){
//        return Math.abs(x1-x2)+Math.abs(y1-y2);
//    }



//    public static void main(String[] args) {
//        //对于每一个数，其不高兴度至多增加1
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt(); //代表个数
//        int hate = sc.nextInt();    //讨厌的数
//        String hateStr = String.valueOf(hate);
//        int res = 0;
//        for (int i = 0; i < num; i++) {
//            int number = sc.nextInt();
//            if(isContains(fx(number).toCharArray(),0,hateStr.toCharArray(),0)){
//                res++;
//            }
//        }
//        System.out.println(res);
//    }
//    public static boolean isContains(char[] s,int index1,char[] hate,int index2){
//        if(index2==hate.length){
//            return true;
//        }
//        if(index1==s.length){
//            return false;
//        }
//        for(int i=index1;i<s.length;i++){
//            if(s[i]==hate[index2]){
//                if(isContains(s,i+1,hate,index2+1)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public static String fx(int num){
//        StringBuilder sb = new StringBuilder();
//        for(int i=1;i<=num;i++){
//            if((num%i)==0){
//                sb.append(i);
//            }
//        }
//        return sb.toString();
//    }




//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        res=0;
//        findNum(s);
//        System.out.println(res%20210101);
//    }
//    static long res;
//    static char[] chars;
//    public static void findNum(String s){
//        res+=s.length()+1;
//        for(int i=2;i<=s.length();i++){
//           chars = new char[i];
//           set = new HashSet<>();
//           dfs(s.toCharArray(),0,0);
//        }
//    }
//    static Set<Character> set;
//    public static void dfs(char[] arr,int index,int num){
//        if(num==chars.length){
//            res++;
//            return;
//        }
//        if(index==arr.length){
//            return;
//        }
//        for(int i=index;i<arr.length;i++){
//            chars[num] = arr[i];
//            if(set.add(arr[i])) {
//                dfs(arr, i + 1, num + 1);
//                set.remove(arr[i]);
//            }
//        }
//    }
}
