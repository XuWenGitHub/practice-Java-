package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Example
 * @Author: XuWen
 * Date: 2020/8/5 22:13
 * Introduce:
 */
public class Example{
    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main(String args[]){
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}
