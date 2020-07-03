package task.three;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        ArmedPolice chenLong=new ArmedPolice(10034,"成龙",3000,"武警第七旅","第三警监");
        chenLong.setDate("2004-4-1");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //假设每两年增加一次薪资
        //System.out.println(updateMoney("2004年4月1日",chenLong.getDate()));
        for(int i=0;i<updateMoney(chenLong.getDate(),sdf.format(d))/2;i++){
            chenLong.high();
        }
        System.out.println("编号："+chenLong.getPno());
        System.out.println("姓名："+chenLong.getName());
        System.out.println("薪金："+chenLong.getMoney());
        System.out.println("军队名称："+chenLong.getArmyName());
        System.out.println("级别："+chenLong.getGrade());
        System.out.println("起始工作年份："+chenLong.getDate());
        System.out.println("工龄："+updateMoney(chenLong.getDate(),sdf.format(d)));
    }
    public static int updateMoney(String before,String now){
        String regex="-";
        String[] str1 = before.split(regex);
        String[] str2 = now.split(regex);
        int b = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str2[0]);
        return (n-b);
    }
}
