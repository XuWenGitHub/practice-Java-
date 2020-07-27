package practice.one;

public class Demo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(4,5);
        myArrayList.add(5,6);
        myArrayList.display();
//        System.out.println(myArrayList.contains(4));
//        System.out.println(myArrayList.contains(10));
//        System.out.println(myArrayList.search(4));
//        System.out.println(myArrayList.search(10));
//        System.out.println(myArrayList.getPos(4));
//        System.out.println(myArrayList.getPos(10));
        //myArrayList.delKey(1);
        myArrayList.delKey(6);
        myArrayList.display();

    }
}
