package com.ldh.express.base.sql;

/**
 * sql字段类
 * @author Li Dehuan
 * @date 2019年2月14日
 *
 */
public class SqlField {

	private String fieldName;		// 字段名称
	
	private Object fieldValue;		// 字段值

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

}
