package com.ldh.express.base.sql;

import java.util.List;

/**
 * 基础sql参数类
 * @author Li Dehuan
 * @date 2019年2月14日
 *
 */
public class SqlParam {

	private String tableName;		// 表名
	
	private List<SqlField> fields;	// 查询列表
	
	private long id;				// 主键

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<SqlField> getFields() {
		return fields;
	}

	public void setFields(List<SqlField> fields) {
		this.fields = fields;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
