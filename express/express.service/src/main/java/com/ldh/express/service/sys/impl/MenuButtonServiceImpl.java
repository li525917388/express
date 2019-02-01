package com.ldh.express.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.express.dao.sys.MenuButtonDao;
import com.ldh.express.service.sys.MenuButtonService;

/**
 * 菜单-按钮 service 实现类
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
@Service
public class MenuButtonServiceImpl implements MenuButtonService {

	@Resource
	MenuButtonDao menuButtonDao;
	
	
}
