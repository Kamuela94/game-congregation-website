package com.congregation.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.congregation.bean.UserBean;
import com.congregation.resources.Factory;
import com.congregation.resources.PasswordAuthentication;
import java.lang.reflect.Field;
import java.util.List;
import org.hibernate.Session;   
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

public class LoginDAOImpl implements LoginDAO {
	public UserBean login(UserBean user){
		UserEntity entity = new UserEntity();
		try{
			session = HibernateUtility.createSessionFactory().openSession();
			String hql = "SELECT U.token FROM Users U WHERE U.username = :username";
			Query query = session.createQuery(hql);
			query.setParameter("username", user.getUsername());
			List list = query.list();
			if(list.isEmpty()){
				user.setMessage("DAO.USERNAME_NOT_FOUND");
				return user;
			}
			String token = (String)query.list();
			PasswordAuthentication pwa = Factory.createPasswordAuthentication();
			if(pwa.authenticate(user.getPassword().toCharArray(), token)){
				user.setMessage("DAO.LOGIN_SUCCESS");
				return user;
			}else{
				user.setMessage("DAO.LOGIN_FAILURE");
				return user;
			}
		}catch(Exception e){
			Logger logger = LogManager.getLogger(this.class);
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");
		}

	}

	public UserBean signUp(UserBean user){
		UserEntity entity = this.beanToEntity(user);
		Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUtility.createSessionFactory().openSession();
      String hql = "FROM Users U WHERE U.username = :username";
      Query query = session.createQuery(hql);
      query.setParameter("username", user.getUsername());
      if(!query.list().isEmpty()){
      	user.setMessage("DAO.USERNAME_TAKEN");
      }
      transaction = session.getTransaction();
      transaction.begin();
      session.save(entity);

      transaction.commit();

      user.setMessage("DAO_SIGNUP_SUCCESS");
      return user
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      Logger logger = LogManager.getLogger(this.class);
			logger.error(e.getMessage(), e);
      throw new Exception("DAO_TECHNICAL_ERROR")
    } finally {
      if (session != null) {
        session.close();
      }
    }

    HibernateUtility.closeSessionFactory();
  }

	}

	private UserEntity beanToEntity(UserBean user){
		UserEntity entity = new UserEntity();
		entity.setUsername(user.getUsername());
		entity.setPassword(user.getPassword());
		return entity;
	}

	private UserBean entityToBean(UserEntity user){
		UserBean bean = new UserBean();
		bean.setUsername(user.getUsername);
		bean.setPassword(user.getPassword);
		return bean;
	}
}