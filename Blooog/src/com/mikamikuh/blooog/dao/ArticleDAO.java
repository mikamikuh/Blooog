package com.mikamikuh.blooog.dao;

import com.mikamikuh.blooog.entity.Article;
import com.mikamikuh.blooog.entity.User;

public interface ArticleDAO extends AbstractDAO<Article, String> {

	void addArticle(Article article, User author);
}
