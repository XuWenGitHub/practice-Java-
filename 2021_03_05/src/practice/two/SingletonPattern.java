package practice.two;

public class SingletonPattern {
    private SingletonPattern() { }
    private static class Inner {
        private static final SingletonPattern singleton = new SingletonPattern();
    }
    public static SingletonPattern getInstance() {
        return Inner.singleton;
    }
}

