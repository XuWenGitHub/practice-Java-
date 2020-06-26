package cn.itcast_03;

public class MyException extends RuntimeException{
    public MyException(){}

    public MyException(String message){
        super(message);
    }
}

/*public class MyException extends RuntimeException{
}*/
