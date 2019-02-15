package com.ldh.express.service.sys;

import com.ldh.express.base.core.BaseService;
import com.ldh.express.base.util.ServiceResult;
import com.ldh.express.model.sys.MenuButton;

/**
 * 菜单-按钮 service
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
public interface MenuButtonService extends BaseService<MenuButton> {

	/**
	 * 获取左侧菜单
	 * @param uid
	 * @return
	 */
	public ServiceResult<MenuButton> getLeftMenu(long uid);
}
