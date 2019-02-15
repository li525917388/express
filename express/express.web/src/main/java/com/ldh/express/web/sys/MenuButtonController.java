package com.ldh.express.web.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldh.express.model.sys.MenuButton;
import com.ldh.express.service.sys.MenuButtonService;

/**
 * 菜单按钮controller
 * @author Li Dehuan
 * @date 2019年2月13日
 *
 */
@Controller
@RequestMapping("sys/menuButton")
public class MenuButtonController {

	@Resource
	MenuButtonService menuButtonService;
	
	@RequestMapping("queryList")
	@ResponseBody
	public List<MenuButton> queryList(){
		
		System.out.println("123");
		
		List<MenuButton> res = menuButtonService.queryList();
		
		return res;
	}
	
	
}
