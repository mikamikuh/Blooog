package com.mikamikuh.blooog.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikamikuh.blooog.entity.Article;
import com.mikamikuh.blooog.entity.User;
import com.mikamikuh.blooog.service.ArticleService;
import com.mikamikuh.blooog.service.UserService;

@Controller
public class BlooogController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
		Set<Article> articles = articleService.findArticles("aaa");
		model.addAttribute("articles", articles);
		return "index";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createArticle(Model model) {
		model.addAttribute("action", "/Blooog/new");
		model.addAttribute("caption", "New Article");
		return "article";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createArticle(@RequestParam("title") String title,
			@RequestParam("body") String body, Model model) {
		User user = userService.findByUserName("aaa");
		Article article = new Article(title, body, "", new Date(), user);
		articleService.addArticle(article, "aaa");

		return "index";
	}

	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public String showArticle(@PathVariable("id") int id, Model model) {
		Article article = articleService.findArticleById(id);
		model.addAttribute("article", article);
		model.addAttribute("title", article.getTitle());
		String subtitle = "Posted by " + article.getAuthor().getUserName()
				+ " on " + article.getPostedDate().toString();
		model.addAttribute("subtitle", subtitle);
		return "view";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editArticle(@PathVariable("id") int id, Model model) {
		Article article = articleService.findArticleById(id);
		model.addAttribute("article", article);
		model.addAttribute("title", article.getTitle());
		String subtitle = "Posted by " + article.getAuthor().getUserName()
				+ " on " + article.getPostedDate().toString();
		model.addAttribute("subtitle", subtitle);

		model.addAttribute("action", "/Blooog/edit/" + article.getId());
		model.addAttribute("caption", "Edit Article");
		model.addAttribute("article", article);

		return "article";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editArticle(@PathVariable("id") int id,
			@RequestParam("title") String title,
			@RequestParam("body") String body, Model model) {
		Article article = articleService.findArticleById(id);
		article.setTitle(title);
		article.setBody(body);
		articleService.saveArticle(article);

		return editArticle(model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editArticle(Model model) {
		Set<Article> articles = articleService.findArticles("aaa");
		model.addAttribute("articles", articles);
		return "list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteArticle(@PathVariable("id") int id, Model model) {
		Article article = articleService.findArticleById(id);
		articleService.deleteArticle(article);
		return editArticle(model);
	}
}
