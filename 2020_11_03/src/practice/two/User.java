package practice.two;

import java.io.Serializable;

/**
 * @PackgeName: practice.two
 * @ClassName: User
 * @Author: XuWen
 * Date: 2020/11/3 16:15
 * Introduce:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5199715604410776889L;
    private String name;
    private int password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
