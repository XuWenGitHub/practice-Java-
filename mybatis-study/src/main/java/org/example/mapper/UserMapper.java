package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper//启动时会扫描该注解的接口，动态的生成代理类
@Component
public interface UserMapper {

    User selectById(Integer id);

    int insert(User user);

    int delete(Integer id);

    //传入username,password，模糊匹配查询,a%
    //规定username传入的带%，或不带%
    List<User> selectLike(@Param("username") String username,
                          @Param("password") String password,
                          @Param("orderBy") String orderBy);


    List<User> selectAll();

    int batchInsert(List<User> users);
}
