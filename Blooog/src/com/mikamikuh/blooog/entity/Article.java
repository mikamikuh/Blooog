package com.mikamikuh.blooog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "ARTICLE_ID")
	private int id;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "BODY", nullable = false)
	private String body;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

	@Column(name = "POSTED_DATE", nullable = false)
	private Date postedDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User author;

	public Article() {
	}

	public Article(String title, String body, String imageUrl, Date postedDate,
			User author) {
		this.title = title;
		this.body = body;
		this.imageUrl = imageUrl;
		this.postedDate = postedDate;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Article article = (Article) o;

		return id == article.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
