package out.itcast_03;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        //添加数据
        sb.append("廉佳佳爱我");
        System.out.println("sb:"+sb);

        //反转
        sb.reverse();
        System.out.println("sb:"+sb);
    }
}
