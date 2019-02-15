package com.ldh.express.base.util;

import java.util.List;

/**
 * service响应返回实体
 * @author Li Dehuan
 * @date 2019年2月15日
 *
 */
public class ServiceResult<T> {

	private int code;			//编码
	
	private String desc;		//描述
	
	private T object;			//数据
	
	private List<T> list;		//列表数据

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
