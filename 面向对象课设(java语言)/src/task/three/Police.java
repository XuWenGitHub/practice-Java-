package task.three;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Police extends Tool implements Employee{
    private int pno;    //警察号码
    private String name;    //警察姓名
    private double money;  //薪金
    private String date;    //工作日期

    public Police(int pno, String name, int money) {
        this.pno = pno;
        this.name = name;
        this.money = money;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=sdf.format(d);
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String String() {
        return date+name+money;
    }

    @Override
    public void high() {

    }
}
