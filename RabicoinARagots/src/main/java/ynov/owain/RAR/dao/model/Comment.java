package ynov.owain.RAR.dao.model;

import java.util.Date;

public class Comment {
	
	private Integer commentID;
	private String commentContent;
	private Date commentDate;
	private Integer userID;
	private Integer articleID;
	private String authorFirstname;
	private String authorLastname;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getCommentID() {
		return commentID;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public Integer getUserID() {
		return userID;
	}
	
	public Integer getArticleID() {
		return articleID;
	}
	
	public String getAuthorFirstname() {
		return authorFirstname;
	}
	
	public String getAuthorLastname() {
		return authorLastname;
	}
	
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	
	public void setAuthorFirstname(String authorFirstname) {
		this.authorFirstname = authorFirstname;
	}
	
	public void setAuthorLastname(String authorLastname) {
		this.authorLastname = authorLastname;
	}
}
