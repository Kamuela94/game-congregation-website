package com.infy.dao;

import com.congregation.bean.UserBean;

public interface HouseBoatDAO {

	public UserBean login(UserBean user) throws Exception;
	public UserBean signUp(UserBean user) throws Exception;
}