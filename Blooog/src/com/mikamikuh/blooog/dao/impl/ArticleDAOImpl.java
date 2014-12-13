package com.mikamikuh.blooog.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mikamikuh.blooog.dao.ArticleDAO;
import com.mikamikuh.blooog.entity.Article;
import com.mikamikuh.blooog.entity.User;

@Repository
public class ArticleDAOImpl extends AbstractDAOImpl<Article, Integer> implements
		ArticleDAO {

	protected ArticleDAOImpl() {
		super(Article.class);
	}

	@Override
	public void addArticle(Article article, User author) {
		Set<Article> articles = author.getArticles();
		articles.add(article);
		getCurrentSession().saveOrUpdate(article);
	}

	@Override
	public void delete(Article article) {
		getCurrentSession().delete(article);
	}
}
