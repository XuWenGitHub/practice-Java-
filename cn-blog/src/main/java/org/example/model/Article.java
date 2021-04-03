package org.example.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
/**
 * 文章信息
 */
public class Article {
    /**
     * 文章id
     */
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章作者：数据库作为外键关键用户id
     */
    private Integer user_id;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章发表日期
     */
    private Date publishDate;
    /**
     * 文章浏览量
     */
    private Integer viewCount;
    /**
     * 文章评论数
     */
    private Integer commentCount;
}
