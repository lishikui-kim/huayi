package com.example.mimile;

import com.example.mimile.beans.Article;
import com.example.mimile.beans.Comment;
import com.example.mimile.mapper.ArticleMapper;
import com.example.mimile.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MyBtaisTests {
    @Resource
    private CommentMapper commentMapper;

    @Test
    public void selectComment() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }


    //    Autowired在项目中需要有自己的实现类，但是mybatis只有接口，因此这里建议使用    @Resource
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void selectArticle() {
        Article article = articleMapper.getArticle(1);
        System.out.println(article);
    }

}
