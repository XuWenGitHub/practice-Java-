package cn.itcast_02;

public class ObjectTool<T> {
    private T obj;

    public T ObjectTool() {
        return obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
