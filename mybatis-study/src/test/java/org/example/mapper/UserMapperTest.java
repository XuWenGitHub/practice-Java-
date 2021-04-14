package org.example.mapper;

import org.example.Application;
import org.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//指定为Spring环境中的单元测试
@RunWith(SpringRunner.class)
//指定为SpringBoot环境的单元测试，Application为启动类
@SpringBootTest(classes = Application.class)
//使用事务，在SpringBoot的单元测试中会自动回滚
@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByIdTest(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        //user.setNickname("张老三");
        user.setSex(true);
        System.out.println(userMapper.insert(user));
        System.out.println(user);
    }

    @Test
    public void deleteTest(){
        System.out.println(userMapper.delete(5));
    }

    @Test
    public void selectLikeTest(){
        List<User> users = userMapper.selectLike(
                "a%",null,"desc");
        System.out.println(users);
    }

    @Test
    public void selectAllTest(){
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void batchInsertTest(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123");
        user1.setNickname("张老三");
        user1.setSex(true);
        User user2 = new User();
        user2.setUsername("李四");
        user2.setPassword("123");
        user2.setNickname("李阿四");
        user2.setSex(true);
        list.add(user1);
        list.add(user2);

        userMapper.batchInsert(list);
    }
}
