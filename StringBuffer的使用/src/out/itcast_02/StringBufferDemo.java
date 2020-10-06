package out.itcast_02;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        //添加数据
        sb.append("hello").append("world").append("java");
        System.out.println("sb:"+sb);

        //需求：我要把world这个数据替换为"节日快乐";
        sb.replace(5,10,"节日快乐");
        System.out.println("sb:"+sb);
    }
}
