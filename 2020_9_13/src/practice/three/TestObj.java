package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: TestObj
 * @Author: XuWen
 * Date: 2020/9/13 12:08
 * Introduce:
 */
public class TestObj implements Comparable{
    public static void main(String[] args) {
        Object o = new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
