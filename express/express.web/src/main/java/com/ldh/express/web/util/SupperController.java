package com.ldh.express.web.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 父类controller
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public class SupperController {
	
	/**
	 * 获取request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
