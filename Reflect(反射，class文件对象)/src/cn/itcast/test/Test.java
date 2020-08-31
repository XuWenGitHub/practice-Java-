package cn.itcast.test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 通过配置文件运行类中的方法
*
* 反射：
*       需要有配置文件配合使用
*       用class.txt
*       并且你知道有两个键
*           className
*           methodName
* */
public class Test {
    public static void main(String[] args) throws Exception{
        //加载键值对数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("class.txt");
        prop.load(fr);
        fr.close();

        //获取数据
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //反射
        Class c = Class.forName(className);

        Constructor con = c.getDeclaredConstructor();
        con.setAccessible(true);
        Object obj = con.newInstance();

        //调用方法
        Method m = c.getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(obj);
    }

}
