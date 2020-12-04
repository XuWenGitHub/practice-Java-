package practice.one;

public class Main {
    public static void main(String[] args) {
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a,b);
//        System.out.println(a+" "+b);
//        try {
//            int i=100/0;
//            System.out.println(i);
//        }catch (Exception e){
//            System.out.println(1);
//            throw  new RuntimeException();
//        }finally {
//            System.out.println(2);
//        }
//        System.out.println(3);

//        Object o = new Object(){
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//        };
//        System.out.println(o.equals("fred"));

//        int arr[] = new int[10];
//        System.out.println(arr[10]);

//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6 = b4+b5;
//        b3 = (b1+b2);

    }

    private static void operator(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
        final String c="cc";
    }
    public final static native int w();

}
