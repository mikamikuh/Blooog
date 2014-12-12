package com.mikamikuh.blooog.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;
import com.mikamikuh.blooog.dao.ArticleDAO;
import com.mikamikuh.blooog.entity.Article;
import com.mikamikuh.blooog.entity.User;

@Repository
public class ArticleDAOImpl extends AbstractDAOImpl<Article, String> implements
		ArticleDAO {

	protected ArticleDAOImpl() {
		super(Article.class);
	}

	@Override
	public void addArticle(Article article, User author) {
		getCurrentSession().saveOrUpdate(article);

		Set<Article> articles = author.getArticles();
		articles.add(article);
		getCurrentSession().saveOrUpdate(articles);
	}

	@Override
	public void delete(Article article) {
		User author = article.getAuthor();

		getCurrentSession().delete(article);
		Set<Article> articles = author.getArticles();
		articles.remove(article);
		getCurrentSession().saveOrUpdate(articles);
	}
}
