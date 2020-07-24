import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        System.out.println(divisorGame(1000));
    }
    /*
    N == 偶数 先手赢，N==基数，后手赢
    为什么？偶数都能被1整除，偶数-1 == 奇数
    因为 奇数只能被奇数整除，奇数-奇数==偶数。所以 N == 奇数，后手必为偶数。
    偶数先手 只要用1 把 对手做成奇数，对手 只能 做成偶数。按照这个套路，偶数先手最后都能得 到2，必胜。
    奇数先手 只能 留给对方偶数，必须对手失误，还一个偶数给自己，才能赢。题设又说，所有人智商在线。因此奇数必输。

    推导过程：
    相减后对方必输，己方就能赢。 所有大于1的数，都至少能被1整除

    博弈类的问题常常让我们摸不着头脑。当我们没有解题思路的时候，不妨试着写几项试试：

    N = 1N=1 的时候，区间 (0, 1)(0,1) 中没有整数是 nn 的因数，所以此时 Alice 败。
    N = 2N=2 的时候，Alice 只能拿 11，NN 变成 11，Bob 无法继续操作，故 Alice 胜。
    N = 3N=3 的时候，Alice 只能拿 11，NN 变成 22，根据 N = 2N=2 的结论，我们知道此时 Bob 会获胜，Alice 败。
    N = 4N=4 的时候，Alice 能拿 11 或 22，如果 Alice 拿 11，根据 N = 3N=3 的结论，Bob 会失败，Alice 会获胜。
    N = 5N=5 的时候，Alice 只能拿 11，根据 N = 4N=4 的结论，Alice 会失败。
    ......

    */
    public static boolean divisorGame(int N) {
        return (N%2==0);
    }


}
