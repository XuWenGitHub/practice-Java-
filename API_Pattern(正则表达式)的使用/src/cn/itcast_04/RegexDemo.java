package cn.itcast_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 获取功能：
* 获取下面这个字符串中由三个字符组成的单词
* da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?
* */
public class RegexDemo {
    public static void main(String[] args) {
        //定义字符串
        String s = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
        //规则
        String regex = "\\b\\w{3}\\b";

        //把规则编译成模式对象
        Pattern p =Pattern.compile(regex);
        //通过模式对象的到匹配器对象
        Matcher m = p.matcher(s);
        //调用匹配器对象的功能
        //通过find方法就是查找有没有满足条件的子串
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
