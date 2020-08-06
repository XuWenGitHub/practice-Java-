package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: LoginException
 * @Author: XuWen
 * Date: 2020/8/7 1:21
 * Introduce:
 */
public class LoginException extends RuntimeException {
    public LoginException(){

    }
    public LoginException(String message){
        super(message);
    }
}
