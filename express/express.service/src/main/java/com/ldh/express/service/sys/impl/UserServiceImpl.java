package com.ldh.express.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.express.base.core.BaseServiceImpl;
import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.dao.sys.UserDao;
import com.ldh.express.model.sys.User;
import com.ldh.express.service.sys.UserService;

/**
 * 用户service实现类
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource
	UserDao userDao;
	
	/*
	 * 登录
	 * @see com.ldh.express.service.sys.UserService#login(com.ldh.express.model.sys.User)
	 * 2019年2月15日
	 */
	@Override
	public ServiceResult<User> login(User login) {
		
		User user = userDao.login(login);
		
		ServiceResult<User> result = new ServiceResult<User>();
		
		//账号不存在
		if(user == null){
			result.setCode(0);
		}
		//成功
		else if(login.getPwd().equals(user.getPwd())){
			result.setObject(user);
			result.setCode(1);
		}
		//密码错误
		else{
			result.setCode(2);
		}
		
		return result;
	}

}
