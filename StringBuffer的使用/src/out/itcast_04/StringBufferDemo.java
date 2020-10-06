package out.itcast_04;

public class StringBufferDemo {
    public static void main(String[] args) {
        //创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        //添加元素
        sb.append("hello").append("world").append("java");
        System.out.println("sb:"+sb);

        //截取功能
        String s =sb.substring(5);
        System.out.println("s:"+s);
        System.out.println("sb:"+sb);

        String ss = sb.substring(5,10);
        System.out.println("ss:"+ss);
        System.out.println("sb:"+sb);
    }
}
