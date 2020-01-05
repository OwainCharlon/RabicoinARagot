package ynov.owain.RAR.dao.model;

import java.util.Date;

public class Article { 

	private Integer articleID;
	private String articleAuthorFirstname;
	private String articleAuthorLastname;
	private String title;
	private String articleDescription;
	private String articleContent;
	private Date articleDate;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public String getArticleAuthorFirstname() {
		return articleAuthorFirstname;
	}
	
	public String getArticleAuthorLastname() {
		return articleAuthorLastname;
	}
	
	public Integer getArticleID() {
		return articleID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArticleDescription() {
		return articleDescription;
	}
	
	public String getArticleContent() {
		return articleContent;
	}
	
	public Date getArticleDate() {
		return articleDate;
	}
	
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	
	public void setArticleAuthorLastname(String articleAuthorLastname) {
		this.articleAuthorLastname = articleAuthorLastname;
	}
	
	public void setArticleAuthorFirstname(String articleAuthorFirstname) {
		this.articleAuthorFirstname = articleAuthorFirstname;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
}
