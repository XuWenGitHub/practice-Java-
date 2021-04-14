package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {

    //一对一映射，一篇文章关联一个用户
    List<Article> selectAll();
}
