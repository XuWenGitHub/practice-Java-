public class HannoiTa {
    private static int pace=0;   //pace表示步数

    //构造器
    public HannoiTa(){

    }

    /**
     * 模拟盘子移动   (从start移动到end位置)
     * @param disk 第几个盘子
     * @param start 起始柱子
     * @param end   移动到的位置的柱子
     */
    public  void move(int disk,char start,char end){
        System.out.println("第"+(++pace)+"步,"+"盘子"+disk+" "+start+"------------>"+end);
    }

    /**
     * 汉诺塔问题
     * @param n 表示第几个盘子，也表示一共有多少个盘子
     * @param A 起始位置（A柱子）
     * @param B 中转位置（B柱子）
     * @param C 结束位置（C柱子）
     */
    public  void hannoi(int n,char A,char B,char C){
        if(n==1){
            move(n,A,C);
        }else {
            //先把n-1个在A柱的盘子通过C柱子，移动到B柱子
            hannoi(n-1,A,C,B);
            //再把最下面的盘子移动到C塔
            move(n,A,C);
            //再把B柱上的盘子通过A柱子，移动到C柱子
            hannoi(n-1,B,A,C);
        }
    }
}
