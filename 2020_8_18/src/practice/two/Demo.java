package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/18 17:15
 * Introduce:
 */
public class Demo{
    public int add(int a,int b){
        try{
            return a + b;
        }catch(Exception e){
            System.out.println("Catch 语句块");
        }finally{
            System.out.println("finally 语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("和是：" + demo.add(9,34));
    }
}
