package practice.four;

public class Single {
    private Single(){
    }
    private static class Inner{
        private static Single single = new Single();
    }
    public static Single getSingle(){
        return Inner.single;
    }
}
class S{
    private static S s = null;
    private S(){}
    public static S getS(){
        if(s==null){
            synchronized (S.class){
                if(s==null) {
                    s = new S();
                }
            }
        }
        return s;
    }
}
