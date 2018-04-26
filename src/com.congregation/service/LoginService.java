package com.congregation.service;

import com.congregation.bean.UserBean;

public interface LoginService {
	public UserBean login(UserBean user) throws Exception;
}
