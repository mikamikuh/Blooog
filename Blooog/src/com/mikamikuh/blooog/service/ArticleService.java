package com.mikamikuh.blooog.service;

import java.util.Set;

import com.mikamikuh.blooog.entity.Article;

public interface ArticleService {
	
	void addArticle(Article article, String username);

	void saveArticle(Article article);

	void deleteArticle(Article article);

	Set<Article> findArticles(String username);
}
