package practice.two;

public class SingletonPattern2 {
    private static volatile SingletonPattern2 singleton = null;
    private SingletonPattern2(){}
    public static SingletonPattern2 getInstance(){
        if(singleton==null){
            synchronized (SingletonPattern2.class){
                if(singleton==null){
                    singleton = new SingletonPattern2();
                }
            }
        }
        return singleton;
    }
}
