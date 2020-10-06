package out.itcast_01;

public class StringBufferDemo {
    public static void main(String[] args) {
        //创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        //链式编程
        sb.append("hello").append(true).append(12).append(34.56);
        System.out.println("sb:"+sb);

        /* 在指定位置把任意类型的数据插入到字符串缓冲区里面，并返回字符串缓冲区本身 */
        sb.insert(5,"world");
        System.out.println("sb:"+sb);

        //需求：我要删除e这个字符
        //sb.deleteCharAt(1);

        //需求：我要删除第一个l这个字符
        //sb.deleteCharAt(2);

        //需求：我要删除world这个字符串
        //sb.delete(5,10);

        //需求：我要删除所有的数据
        sb.delete(0,sb.length());
        System.out.println("sb:"+sb);
    }
}
