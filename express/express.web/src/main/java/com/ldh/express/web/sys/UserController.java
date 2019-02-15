package com.ldh.express.web.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.model.sys.User;
import com.ldh.express.service.sys.UserService;

/**
 * 用户controller
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
@RequestMapping("sys/user")
@Controller
public class UserController {

	@Resource
	UserService userService;
	
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public ServiceResult<User> login(User user){
		
		ServiceResult<User> res = userService.login(user);
		
		return res;
	}
	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list(){
		
		return "sys/user/list";
	}
}
