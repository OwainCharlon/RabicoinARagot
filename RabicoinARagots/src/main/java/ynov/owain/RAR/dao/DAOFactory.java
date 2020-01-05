package ynov.owain.RAR.dao;

import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.DAOArticleImpl;

import ynov.owain.RAR.dao.DAOUser;
import ynov.owain.RAR.dao.DAOUserImpl;

import ynov.owain.RAR.dao.DAOComment;
import ynov.owain.RAR.dao.DAOCommentImpl;

import ynov.owain.RAR.dao.MySQLManager;

public class DAOFactory {
	
	private MySQLManager manager;
	
	
	private DAOArticle daoArticle;
	
	
	private DAOUser daoUser;
	
	
	private DAOComment daoComment;
	
	
	public DAOFactory()
	{
		manager = MySQLManager.getInstance();
		daoArticle = new DAOArticleImpl(manager.getConnection());
		daoUser = new DAOUserImpl(manager.getConnection());
		daoComment = new DAOCommentImpl(manager.getConnection());
	}
	
	
	public DAOArticle getDaoArticle()
	{
		return daoArticle;
	}
	
	
	public DAOUser getDaoUser()
	{
		return daoUser;
	}
	
	
	public DAOComment getDaoComment()
	{
		return daoComment;
	}
}