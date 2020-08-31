package cn.itcast.test;

import java.lang.reflect.Field;

public class Tool {
    public void setProperty(Object obj,String propertName,Object value) throws NoSuchFieldException, IllegalAccessException {
        //根据对象获取字节码文件对象
        Class c = obj.getClass();
        //获取该对象的propertName成员变量
        Field field = c.getDeclaredField(propertName);
        //取消访问检查
        field.setAccessible(true);
        //给对象的成员变量赋值为指定的值
        field.set(obj,value);
    }
}
