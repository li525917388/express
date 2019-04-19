package com.ldh.express.web.util;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.express.base.util.BaseConstants;
import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.model.sys.MenuButton;
import com.ldh.express.service.sys.MenuButtonService;

/**
 * 
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
@RequestMapping("page")
@Controller
public class PageController extends SupperController {

	@Resource
	MenuButtonService menuButtonService;
	
	/**
	 * 访问系统
	 * @return
	 */
	@RequestMapping("index")
	public String main(){
		System.out.println("进入主页");
		
		//User user = (User) getRequest().getSession().getAttribute(BaseConstants.SESSION_USER);
		
		ServiceResult<MenuButton> result = menuButtonService.getLeftMenu(1L);
		
		getRequest().getSession().setAttribute(BaseConstants.USER_ROLE_MENUS, result.getList());
		
		return "index";
	}
}
