package com.ldh.express.service.authority.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.express.base.core.BaseServiceImpl;
import com.ldh.express.dao.authority.RoleDao;
import com.ldh.express.model.authority.Role;
import com.ldh.express.service.authority.RoleService;

/**
 * 角色service实现类
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Resource
	RoleDao roleDao;
	
}
