package com.example.mimile.mapper;

import com.example.mimile.beans.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public Article getArticle(int id);
}
