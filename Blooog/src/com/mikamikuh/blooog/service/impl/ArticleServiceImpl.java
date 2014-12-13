package com.mikamikuh.blooog.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikamikuh.blooog.dao.ArticleDAO;
import com.mikamikuh.blooog.dao.UserDAO;
import com.mikamikuh.blooog.entity.Article;
import com.mikamikuh.blooog.entity.User;
import com.mikamikuh.blooog.service.ArticleService;

@Service("articleService")
@Transactional(readOnly = false)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDao;

	@Autowired
	private UserDAO userDao;

	@Override
	public void saveArticle(Article article) {
		articleDao.saveOrUpdate(article);
	}

	@Override
	public void addArticle(Article article, String userName) {
		User user = userDao.findById(userName);
		if (user != null) {
			articleDao.addArticle(article, user);
		}
	}

	@Override
	public void deleteArticle(Article article) {
		articleDao.delete(article);
	}

	@Override
	public Set<Article> findArticles(String userName) {
		User user = userDao.findById(userName);
		return new HashSet<Article>(user.getArticles());
	}

	@Override
	public Article findArticleById(int id) {
		Article article = articleDao.findById(id);
		return article;
	}
}
