import java.util.Scanner;

public class Main {

    /*
    男男、女女、男女
    每个部门，3名男，3名女
    双方两名球员的比赛实力值之和高的一方会获胜
    （相等则部门A的队伍会获胜）
    使部门B在三场比赛中的至少两场能获胜，有多少种不同的比赛安排方案
    （两个比赛安排方案，只要存在任意一场比赛中任意一位球员不同，
    则视为方案不同）

    测试用例：
    4
    100 50 40 100 50 40
    50 45 40 50 45 40
    2 2 2 2 2 2
    1 1 1 1 1 1
    1 1 1 1 1 1
    2 2 2 2 2 2
    1 2 3 3 2 1
    1 2 3 3 2 1

    1
    0
    81
    13
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //代表场数
        for (int i = 0; i < n; i++) {
            int[] a = new int[6];
            int[] b = new int[6];
            for (int j = 0; j < 6; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < 6; j++) {
                b[j] = sc.nextInt();
            }
            nanNan = new int[4];
            nvNv = new int[4];
            nanNv = new int[4];
            aFlag = new boolean[6];
            bFlag = new boolean[6];
            res = 0;
            dfs(a,b,0);
            System.out.println(res);
        }
    }
    static int[] nanNan;   //代表男男 0,1下标代表A队，2,3下标代表B队
    static int[] nvNv; //女女 0,1下标代表A队，2,3下标代表B队
    static int[] nanNv;    //男女 0,1下标代表A队，2,3下标代表B队
    static boolean[] aFlag; //a对队员,去判断该队员是否上场
    static boolean[] bFlag; //b对队员，去判断该队员是否上场
    static int res; //多少种可能

    /**
     * dfs+回溯去匹配所有的可能
     * @param a a队选手评分
     * @param b b队选手评分
     * @param index 代表男男比赛和女女比赛下标，也就是nanNan[index],nvNv[index]
     */
    public static void dfs(int[] a,int[] b,int index){
        if(index==4){   //当男男和女女比赛全部设置完毕后，那么男女比赛也就确定了，因为人刚好用完
            int nanNvIndex = 0; //去设置男女混合双打人员
            for (int i = 0; i < 6; i++) {
                if(!aFlag[i]){
                    nanNv[nanNvIndex++] = a[i];
                }
            }
            for (int i = 0; i < 6; i++) {
                if(!bFlag[i]){
                    nanNv[nanNvIndex++] = b[i];
                }
            }
            int temp1 = 0;  //代表男男比赛A和B队谁胜利，>0那么B队胜利，<0那么A队胜利
            int temp2 = 0;  //代表女女比赛A和B队谁胜利，>0那么B队胜利，<0那么A队胜利
            int temp3 = 0;  //代表男女比赛A和B队谁胜利，>0那么B队胜利，<0那么A队胜利
            for (int i = 0; i < 4; i++) {
                if(i<2){
                    temp1-=a[nanNan[i]];
                    temp2-=a[nvNv[i]];
                    temp3-=nanNv[i];
                }else{
                    temp1+=b[nanNan[i]];
                    temp2+=b[nvNv[i]];
                    temp3+=nanNv[i];
                }
            }

            //B队胜利，sum+=1，A队胜利，sum-=1
            int sum = temp1>0?1:-1;
            sum+=(temp2>0?1:-1);
            sum+=(temp3>0?1:-1);
            if(sum>0) { //判断B队最终是否能胜利，如果胜利，这就是一种方案
                res++;
            }
            return;
        }



        if(index<2){    //index为0和1是A队的队员，设置A队，男男双打和女女双打
            for (int i = 0; i < 3; i++) {   //遍历A队的男队员
                if(aFlag[i]||(index==1&&nanNan[index-1]>i)){
                    //当该队员已经上场or
                    //设置男男第二个的下标比前一个下标小，那么直接跳过
                    //意思就跳过1,0  因为会去遍历0,1
                    continue;
                }
                nanNan[index] = i;  //设置男男A队成员的下标
                aFlag[i] = true;    //设置A对该成员已经参加比赛

                for(int j=3;j<6;j++){   //遍历A队的女队员
                    if(aFlag[j]||(index==1&&nvNv[index-1]>j)){
                        //当该队员已经上场or
                        //设置女女第二个的下标比前一个下标小，那么直接跳过
                        //意思就跳过1,0  因为会去遍历0,1
                        continue;
                    }
                    nvNv[index] =j; //这是女女A队成员的下标
                    aFlag[j] = true;    //这是A队该成员已经参加比赛
                    dfs(a,b,index+1);   //去设置男男和女女比赛的下一个下标
                    nvNv[index] =-1;    //回溯，重置
                    aFlag[j] = false;   //回溯，重置
                }

                nanNan[index] = -1; //回溯，重置
                aFlag[i] = false;   //回溯，重置
            }
        }else{  //设置B队，男男双打和女女双打
            for (int i = 0; i < 3; i++) {
                if(bFlag[i]||(index==3&&nanNan[index-1]>i)){
                    continue;
                }
                nanNan[index] = i;
                bFlag[i] = true;
                for(int j=3;j<6;j++){
                    if(bFlag[j]||(index==3&&nvNv[index-1]>j)){
                        continue;
                    }
                    nvNv[index] =j;
                    bFlag[j] = true;
                    dfs(a,b,index+1);   //去设置下一个下标
                    nvNv[index] =-1;
                    bFlag[j] = false;
                }
                nanNan[index] = -1;
                bFlag[i] = false;
            }
        }

    }
}
