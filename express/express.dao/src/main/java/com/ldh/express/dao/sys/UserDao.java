package com.ldh.express.dao.sys;

import com.ldh.express.model.sys.User;

/**
 * 用户dao
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public interface UserDao {

	/**
	 * 登录校验
	 * @param login
	 * @return
	 */
	User login (User login);
}
