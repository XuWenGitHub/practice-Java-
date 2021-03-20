import java.util.*;

/*
1 0 1 0
1 1 1 1
1 1 0 1
 */
public class Main {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] splits = s.split(";");  //代表有多少行
//        int lie = splits[0].split(",").length;//代表列
//        int hang = splits.length;
//        int[][] arr = new int[hang][lie];
//        int i = 0;    //代表行
//        for (String element : splits) {
//            int j = 0;    //代表列
//            for (String value : element.split(",")) {
//                arr[i][j++] = Integer.parseInt(value);
//            }
//            i++;
//        }
//        flag = new boolean[hang][lie];  //代表当前位置走过没有
//        res = Integer.MAX_VALUE;
////        int flag = dfs(arr, 0, 0);
//        System.out.println(dfs(arr,0,0));
////        if(flag){
////            System.out.println(res);
////        } else {
////            System.out.println(0);
////        }
//    }



    static int res;
    static boolean[][] flag;

    //i代表当前的行，j代表当前的列,num代表当前步数
    /*
1 0 1 0
1 1 1 1
1 1 0 1
 */
    public static int dfs(int[][] arr, int i, int j) {
        if (i >= arr.length || i < 0 || j < 0 || j >=arr.length || arr[i][j] == 0||flag[i][j]) {
            return 0;
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            //代表走到终点了
            return 1;
        }

        flag[i][j] = true;
        return 1+Math.min(dfs(arr,i+1,j),dfs(arr,i,j+1));
    }
}

////第二题
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt(); //总顾客数
//        long[][] arriveTimeAndPay = new long[num][2];
//        for(int i=0;i<num;i++){
//            String s = sc.next();
//            String[] split = s.split(",");
//            long arriveTime = Integer.parseInt(split[0]);    //顾客挑选完商品的时间
//            long payDuration = Integer.parseInt(split[1]);   //付款的时间
//            arriveTimeAndPay[i][0] = arriveTime;
//            arriveTimeAndPay[i][1] = payDuration;
//        }
//        long res = 0;    //所有顾客的总结账的时间
//        if(arriveTimeAndPay.length==0){
//            System.out.println(res);
//            return;
//        }
//        long time = arriveTimeAndPay[0][0];   //记录当前的时间，第一个客人挑选完商品的时间
//        for(int i=0;i<num;i++){
//            //挑完商品去结账的时间
//            long arriveTime = arriveTimeAndPay[i][0];
//            //当前顾客操作付款的时间
//            long payDuration = arriveTimeAndPay[i][1];
//            if(arriveTime>time){   //表示玩家还没到，所以要把时间更新成玩家到了后的时间
//                time=arriveTime;    //如果去结账的时间，现在还没有到
//            }else if(arriveTime==time){     //表示玩家到了，并且，不需要等待
//
//            }else{//表示当前玩家，刚刚排队等待了
//                res+=(time-arriveTime); //当前顾客刚刚等待的时间
//            }
//            //当前顾客结账需要的时间
//            res+=payDuration;   //总时间加上顾客操作付款的时间
//            time+=payDuration;  //当前时间加上顾客操作付款的时间
//        }
//        System.out.println(res);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String oldWords = sc.nextLine();
//        String newWords = sc.nextLine();
//        Map<Integer, String> old = getMap(oldWords);
//        Map<Integer, String> newWord = getMap(newWords);
//        Set<String> res = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        for (Map.Entry<Integer, String> entry : old.entrySet()) {
//            Integer key = entry.getKey();
//            String value = entry.getValue();
//            if (newWord.containsKey(key)) {   //新的也有该key
//                if (!value.equals(newWord.get(key)) ) {    //表示value不相同
//                    String s = "modify-" + key;
//                    res.add(s);
//                }
//                newWord.remove(key);    //删除新的中遍历过了的
//            } else {  //表示新的没有这个key
//                String s = "delete-" + key;
//                res.add(s);
//            }
//        }
//        for (Map.Entry<Integer, String> entry : newWord.entrySet()) {
//            Integer key = entry.getKey();
//            String s = "add-"+key;
//            res.add(s);
//        }
//        boolean flag = true;//表示是否是第一个输出
//        for(String s:res){
//            if(flag){
//                System.out.print(s);
//                flag = false;
//            }else{
//                System.out.print(","+s);
//            }
//        }
//    }
//
//    public static Map<Integer, String> getMap(String str) {
//        Map<Integer, String> map = new TreeMap<>();
//        String[] keyAndValue = str.split(",");
//        for (String element : keyAndValue) {
//            String[] split = element.split("-");
//            Integer key = Integer.parseInt(split[0]);
//            String value = split[1];
//            map.put(key, value);
//        }
//        return map;
//    }
//}
