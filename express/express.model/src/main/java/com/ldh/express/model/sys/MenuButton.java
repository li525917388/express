package com.ldh.express.model.sys;

import java.util.List;

import com.ldh.express.base.annotation.TempField;
import com.ldh.express.base.core.BaseModel;

/**
 * 菜单-按钮实体
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
public class MenuButton extends BaseModel {

	private String menuCode;		// 菜单编号
	
	private String menuName;		// 菜单名称
	
	private int menuType;			// 菜单类型。1:菜单，2：按钮
	
	private int menuLevel;			// 菜单等级
	
	private String url;				// url
	
	private String icon;			// 菜单图标样式
	
	private String pcode;			// 上级菜单编号
	
	private String describe;		// 描述
	
	private String openType;		// 打开方式
	
	private int menuOrder;			// 菜单顺序
	
	@TempField
	private List<MenuButton> childList;	//子菜单

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuType() {
		return menuType;
	}

	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public List<MenuButton> getChildList() {
		return childList;
	}

	public void setChildList(List<MenuButton> childList) {
		this.childList = childList;
	}
	
}
