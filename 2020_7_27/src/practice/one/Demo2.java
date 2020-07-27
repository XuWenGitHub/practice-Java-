package practice.one;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(0,1);
        arrayList.add(0,2);
        arrayList.add(0,3);
        arrayList.add(0,4);
        arrayList.add(0,5);
        arrayList.list();
        arrayList.del(3);
        arrayList.list();
    }
}
