package com.ldh.express.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.express.base.core.BaseServiceImpl;
import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.dao.sys.MenuButtonDao;
import com.ldh.express.model.sys.MenuButton;
import com.ldh.express.service.sys.MenuButtonService;

/**
 * 菜单-按钮 service 实现类
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
@Service("MenuButtonService")
public class MenuButtonServiceImpl extends BaseServiceImpl<MenuButton> implements MenuButtonService {

	@Resource
	MenuButtonDao menuButtonDao;


	@Override
	public ServiceResult<MenuButton> getLeftMenu(long uid) {
		ServiceResult<MenuButton> result = new ServiceResult<MenuButton>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("menu_type", 1);
		params.put("menu_level", 1);
		
		List<MenuButton> list = this.queryList(params);
		
		for(MenuButton menu : list){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("menu_type", 1);
			map.put("pcode", menu.getMenuCode());
			
			List<MenuButton> childList = this.queryList(map);
			
			menu.setChildList(childList);
		}
		
		result.setCode(1);
		result.setList(list);
		
		return result;
	}
	
	
}
