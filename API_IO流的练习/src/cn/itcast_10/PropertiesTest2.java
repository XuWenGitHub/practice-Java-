package cn.itcast_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
* 客户玩猜数字小游戏，最多只能试玩5次，然后就要提示用户
* 游戏试玩已结束，请付费
* */
public class PropertiesTest2 {
    public static void main(String[] args) throws IOException {
        //把数据加载到集合中
        Properties prop = new Properties();
        prop.load(new FileReader("count.txt"));

        //GuessNumber.start();
        // 我自己的程序，我当然知道里面的键是谁
        String value = prop.getProperty("count");
        int number = Integer.parseInt(value);

        if(number>5){
            System.out.println("游戏试玩已结束，请付费");
            System.exit(0);
        }else{
            number++;
            prop.setProperty("count",String.valueOf(number));
            prop.store(new FileWriter("count.txt"),null);

            GuessNumber.start();
        }

    }
}
