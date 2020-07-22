package practice.one;

/**
 * 汉诺塔类
 */
public class Hannoi {
    private int pace;    //默认为0
    public Hannoi(){

    }

    /**
     * 模拟鼠标移动,用private修饰，不需要外部调用
     * 第n个盘子，从start柱子移动到end柱子
     * @param n 表示第几个盘子
     * @param start 表示起始柱子
     * @param end   表示最终柱子
     */
    private void move(int n,char start,char end){
        System.out.println("第"+(++pace)+"次移动,盘子"+n+"从"+start+"柱子移动到"+end+"柱子");
    }

    /**
     * 汉诺塔递归实现
     * @param n 表示第几个盘子（最开始也表示总盘子数量）
     * @param A 表示A柱子
     * @param B 表示B柱子
     * @param C 表示C柱子
     */
    public void hannoiStart(int n,char A,char B,char C){
        if(n==1){
            //递归结束条件，只剩下最后一个盘子，直接移动到C柱子
            move(n,A,C);
        }else{
            //先把A柱子上面的通过中转柱C移动到B柱子
            hannoiStart(n-1,A,C,B);
            //再把A柱子最下面的那一个最大的盘子，放到C柱子
            move(n,A,C);
            //最后把B柱子上面的通过中转柱A移动到C柱子
            hannoiStart(n-1,B,A,C);
        }
    }
}
