package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/25 8:48
 * Introduce:
 */
class B{
    int a=1;
    public void method(){
        System.out.println("B");
    }
}
public class Demo{
    int a = 10;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(9);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        for (int i=0;i<12;i++){
            System.out.println(i+":"+bst.search(i));
        }
        System.out.println(new BST().search(1));

        method2();
        method2();
        method2();
    }
    public static void method2(){
        System.out.println();
    }
}
