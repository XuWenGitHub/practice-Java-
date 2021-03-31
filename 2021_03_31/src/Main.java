public class Main {
    /*
    现在有一根蜡烛长n厘米，从一端点火，然后对n-1个位置进行随机切割，
    将蜡烛分为两段，x和n-x，等较短的一端燃尽后
    （这里假设x段比较短，较短的一段燃尽后，两段蜡烛长度就变成了0和n-x-x了，注意这里两段蜡烛是同时在燃烧！！）,
    再对剩余的蜡烛（即n-x-x段）进行下一段切割
    注意：最多只能切割两次
    一种切割方案会产生一个蜡烛燃烧的时间t
    求所有切割方案下蜡烛燃烧时间的期望值
     */
    /*
    分析：
    一个长 n cm的蜡烛，每个位置的切割概率都相同，都为1/(n-1)
    切割后，两种情况：
    1：两根一样长：时间就是：长度
    2：一根长m1，一根短m2。
       燃烧m2分钟，短的燃烧燃尽

    蜡烛还剩下：m2-m1长度。第一次每个位置点的切割概率都相同

    注意：：：：但是第二次切割的时候，概率不同！！！！！！！！！！！！！
    例如：7cm的蜡烛
    第一次切一个5cm，一个2cm，有6中切法
    第二次切一个5cm的，有4中切法，概率都是不同的

    一个时间t的概率：
    如果只能切割一次：
    第一次切割点的概率*第一次燃烧的时间

    如果可以切割两次：
    第一次切割点的概率*第二次切割点的概率*(第一次燃烧的时间+第二次燃烧的时间)

     */
    static int[] two;  //two[0]=第一次切割前长度-1=第一次有多少种切法，two[1]=第二次切割前长度-1=第二次有多少种切法
    static double n;    //记录最终的平均燃烧蜡烛时间的期望值
    //len代表长度，cur代表当前所用的时间,count代表第几次切割
    public static void dfs(int len,int cur,int count){
        if(len==1||len==2){
            double time = cur+1;
            double cor = 1.0/(two[0]*two[1]);   //当前所用时间*切割的可能性
            n+=(time*cor);
            return;
        }
        if(count==3){
            //切割两次后，目前准备切割第三次
            //但是不能切割，直接算当前长度的概率
            double time = cur+len;
            double cor = 1.0/(two[0]*two[1]);   //就算只切割一次，two[1]也为1
            n+=(time*cor);
            return;
        }

        for(int i=1;i<len;i++){
            //代表从i位置切割，切割成i长度和len-i长度两个蜡烛
            int a = Math.max(i,len-i);  //长的大小
            int b = Math.min(i,len-i);  //短的大小
            int nextLen = a-b;
            two[count-1] = len-1; //记录当前次数，有多少种切法
            if(nextLen!=0){   //代表还可以切割,当前切割成一长一短
                dfs(nextLen,cur+b,count+1);
            }else { //代表不能切割了
                double time = cur+a;
                double cor = 1.0/(two[0]*two[1]);
                n+=(time*cor);
            }
            two[count-1] = 1;   //回溯的时候，要去设置当前次数，切割前的长度设置为1
        }
    }
    public static double method(int len){
        two = new int[2];
        two[0] = 1;
        two[1] = 1;
        dfs(len,0,1);
        return n;
    }
    public static void main(String[] args) {
        System.out.println(method(10));
    }
}
