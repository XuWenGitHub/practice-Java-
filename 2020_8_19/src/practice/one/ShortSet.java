package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: ShortSet
 * @Author: XuWen
 * Date: 2020/8/19 16:22
 * Introduce:
 */
import java.util.*; public class ShortSet{
    public static void main(String args[]) {
        Set<Short> s=new HashSet<Short>();
        for(short i = 0; i<100; i++) {
            s.add(i);
            s.remove(i);
        }
        System.out.println(s.size());
    }
}
