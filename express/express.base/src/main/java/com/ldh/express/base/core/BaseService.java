package com.ldh.express.base.core;

import java.util.List;
import java.util.Map;

/**
 * 基础service
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
public interface BaseService<T> {

	/**
	 * 查询全部数据
	 * @return
	 */
	List<T> queryList();
	
	
	/**
	 * 带参数查询
	 * @return
	 */
	List<T> queryList(Map<String, Object> params);
	
	
	/**
	 * 新增数据
	 * @param t
	 * @return
	 */
	int insert(T t);
	
	
	/**
	 * 修改数据
	 * @param t
	 * @return
	 */
	int update(T t);
	
	
	/**
	 * 修改数据（部分）
	 * @param params
	 * @return
	 */
	int update(Map<String, Object> params);
	
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int delete(long id);
	
	
	/**
	 * 删除数据
	 * @param params
	 * @return
	 */
	int delete(Map<String, Object> params);
}
