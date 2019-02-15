package com.ldh.express.model.authority;

import com.ldh.express.base.core.BaseModel;

/**
 * 角色实体
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public class Role extends BaseModel {

	private String roleCode;	//角色编号
	
	private String roleName;	//角色名称
	
	private String remark;		//备注

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
