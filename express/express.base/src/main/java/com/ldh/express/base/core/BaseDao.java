package com.ldh.express.base.core;

import java.util.List;
import java.util.Map;

import com.ldh.express.base.sql.SqlParam;

/**
 * 基础dao
 * @author Li Dehuan
 * @date 2019年2月13日
 *
 */
public interface BaseDao {

	
	/**
	 * 查询全部数据
	 * @return
	 */
	List<Map<String, Object>> queryList(SqlParam sqlParam);
	
	
	/**
	 * 带参数查询
	 * @return
	 */
	List<Map<String, Object>> queryParamList(SqlParam sqlParam);
	
	
	/**
	 * 新增
	 * @param sqlParam
	 * @return
	 */
	int insert(SqlParam sqlParam);


	
	/**
	 * 修改
	 * @param sqlParam
	 * @return
	 */
	int update(SqlParam sqlParam);


	
	/**
	 * 删除
	 * @param sqlParam
	 * @return
	 */
	int delete(SqlParam sqlParam);


	
	/**
	 * 条件删除
	 * @param sqlParam
	 * @return
	 */
	int deleteParams(SqlParam sqlParam);
}
