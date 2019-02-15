package com.ldh.express.service.sys;

import com.ldh.express.base.core.BaseService;
import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.model.sys.User;

/**
 * 用户service
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public interface UserService extends BaseService<User> {
	
	/**
	 * 登录校验
	 * @param login
	 * @return
	 */
	ServiceResult<User> login (User login);
}
