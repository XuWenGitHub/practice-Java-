package practice.one;
////一只青蛙一次可以跳上1级台阶，也可以跳上2级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。
/*
分析：如果n阶有f(n)种跳法
    f(1)=1;
    f(2)=2;
    f(3)=3=f(1)+f(2);
    f(n)=f(n-1)+f(n-2)
 */
public class FrogJumpStep {
    public FrogJumpStep(){

    }

    /**
     * 超级青蛙跳台阶:一只青蛙跳台阶，一次可以跳1阶，可以2阶，其能力足够强大以至于一次可以跳n阶。
     * 那么，台阶为n时，有多少种跳法。
     * 分析；最后一步，青蛙可以从n-1个台阶跳，也可以是n-2个台阶.....也可是第一个台阶跳
     * f(n)=f(n-1)+f(n-2)+...+f(2)+f(1)
     * f(n-1)=f(n-2)+f(n-3)+ ... +f(2) +f(1)
     * 最终得出：f(n)=f(n-1)+f(n-1)
     * @param n 一共有多少个台阶
     * @return  有多少种跳法
     */
    public int superJumpStep(int n){
        if(n==1){
            return 1;
        }
        return 2*superJumpStep(n-1);
    }

    /**
     * 青蛙跳台阶有多少种跳法
     * @param n 一共有多少个台阶
     * @return  有多少种跳法
     */
    public int jumpStep(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return jumpStep(n-1)+jumpStep(n-2);
    }
}
