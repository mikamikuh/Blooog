package com.mikamikuh.blooog.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println(body);
		System.out.println(model);
		User user = userService.findByUserName("aaa");
		Article article = new Article(title, body, "", new Date(), user);
		articleService.addArticle(article, "aaa");

		return "article";
	}
}
