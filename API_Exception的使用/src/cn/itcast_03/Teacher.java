package cn.itcast_03;

public class Teacher {
    public void check(int score) throws MyException {
        if(score>100||score<0){
            throw new MyException("分数必须在0-100之间");
        }else {
            System.out.println("分数没有问题");
        }
    }

    //针对MyExcption继承自RuntimeExcption
//    public void check(int score) throws MyException {
//        if(score>100||score<0){
//            throw new MyException("分数必须在0-100之间");
//        }else {
//            System.out.println("分数没有问题");
//        }
//    }
}
