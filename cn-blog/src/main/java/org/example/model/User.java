package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
/**
 * 用户信息：模仿数据库的实体类
 */
public class User {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String head;
    /**
     * 生日
     */
    private Date birthday;
}
