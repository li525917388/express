package com.ldh.express.web.sys.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户controller
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
@RequestMapping("sys/user")
@Controller
public class SysUserController {

	@RequestMapping("index")
	public String test(){
		System.out.println("进来了...");
		
		return "index";
	}
}
