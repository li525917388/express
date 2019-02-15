package com.ldh.express.base.core;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.express.base.annotation.TempField;
import com.ldh.express.base.sql.SqlField;
import com.ldh.express.base.sql.SqlParam;
import com.ldh.express.base.util.MyRunException;
import com.ldh.express.base.util.ServiceResult;

/**
 * 基础service实现类
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	protected BaseDao baseDao;

	/*
	 * 获取全部实体
	 * @see com.ldh.express.base.core.BaseService#queryList()
	 * 2019年2月14日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryList() {

		List<T> list = new ArrayList<T>();
		
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);

		List<Map<String, Object>> resList = baseDao.queryList(sqlParam);
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName(beanType);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MyRunException("未找到" + beanType);
		}
		

		for(Map<String, Object> res : resList){
			T t = null;
			
			Set<Entry<String, Object>> entrys = res.entrySet();
			
			try {
				t = (T) clazz.newInstance();
			} catch (InstantiationException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			//遍历map
			for(Entry<String, Object> entry : entrys){
				String key = entry.getKey();		//字段名
				Object value = entry.getValue();	//字段值
				
				String name = toProperty(key);		//转驼峰
				
				Field f = null;
				
				try {
					f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					
					try {
						f.set(t, value);	// 赋值
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} catch (NoSuchFieldException e) {
					//子类未找到属性，去父类找
					Field pf = this.getSurperField(clazz,name);
					
					if(pf != null){
						try {
							pf.set(t, value);		// 赋值
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			
			list.add(t);
		}

		return list;
	}
	
	
	

	/*
	 * 带参查询
	 * @see com.ldh.express.base.core.BaseService#queryList(java.lang.Object)
	 * 2019年2月15日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryList(Map<String, Object> params) {
		List<T> list = new ArrayList<T>();
		
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		List<SqlField> fields = new ArrayList<SqlField>();
		
		for(Entry<String, Object> entry : params.entrySet()){
			String key = entry.getKey();		//字段名
			Object value = entry.getValue();	//字段值
			
			value = value == null ? "" : value;
			
			SqlField sqlField = new SqlField();
			sqlField.setFieldName(this.changeName(key));
			sqlField.setFieldValue(value);
			
			fields.add(sqlField);
		}
		
		sqlParam.setFields(fields);
		
		List<Map<String, Object>> resList = baseDao.queryParamList(sqlParam);
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName(beanType);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MyRunException("未找到" + beanType);
		}

		for(Map<String, Object> res : resList){
			T o = null;
			
			Set<Entry<String, Object>> entrys = res.entrySet();
			
			try {
				o = (T) clazz.newInstance();
			} catch (InstantiationException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			//遍历map
			for(Entry<String, Object> entry : entrys){
				String key = entry.getKey();		//字段名
				Object value = entry.getValue();	//字段值
				
				String name = toProperty(key);		//转驼峰
				
				Field f = null;
				
				try {
					f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					
					try {
						f.set(o, value);	// 赋值
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} catch (NoSuchFieldException e) {
					//子类未找到属性，去父类找
					Field pf = this.getSurperField(clazz,name);
					
					if(pf != null){
						try {
							pf.set(o, value);		// 赋值
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			
			list.add(o);
		}

		return list;
	}

	
	/*
	 * 新增
	 * @see com.ldh.express.base.core.BaseService#insert(java.lang.Object)
	 * 2019年2月15日
	 */
	@Override
	public int insert(T t) {
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		Field[] fields = t.getClass().getDeclaredFields();
		List<SqlField> sqlFields = new ArrayList<SqlField>();
		
		for(Field f : fields){
			//判断是否临时注解
			boolean  isTemp = isTemp(f);
			if(isTemp){
				continue;
			}
			
			f.setAccessible(true); 			//设置私有属性公有
			
			SqlField sqlField = new SqlField();
			
			Object v = null;
			
			try {
				v = f.get(t);
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new MyRunException("新增获取属性值失败：" + e.getMessage());
			}
			
			if(v == null){
				v = "";
			}
			
			sqlField.setFieldName(this.changeName(f.getName()));	//字段名称
			sqlField.setFieldValue(v);	//字段值
			
			sqlFields.add(sqlField);
		}
		
		sqlParam.setFields(sqlFields);
		
		int res = baseDao.insert(sqlParam);
		
		return res;
	}

	/*
	 * 更新
	 * @see com.ldh.express.base.core.BaseService#update(java.lang.Object)
	 * 2019年2月15日
	 */
	@Override
	public int update(T t) {
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		Class<? extends Object> clazz = t.getClass();
		
		Field[] fields = clazz.getDeclaredFields();
		List<SqlField> sqlFields = new ArrayList<SqlField>();
		
		for(Field f : fields){
			//判断是否临时注解
			boolean  isTemp = isTemp(f);
			if(isTemp){
				continue;
			}
			
			f.setAccessible(true); 			//设置私有属性公有
			
			SqlField sqlField = new SqlField();
			
			Object v = null;
			
			try {
				v = f.get(t);
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new MyRunException("新增获取属性值失败：" + e.getMessage());
			}
			
			if(v == null){
				v = "";
			}
			
			sqlField.setFieldName(this.changeName(f.getName()));	//字段名称
			sqlField.setFieldValue(v);	//字段值
			
			sqlFields.add(sqlField);
		}
		
		sqlParam.setFields(sqlFields);
		
		long id = 0;
		
		///找ID
		try {
			
			Field f = clazz.getDeclaredField("id");		//搜索ID属性
			
			f.setAccessible(true);
			
			id = f.getLong(t);

		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			//找父类的方法
			Field pf = getSurperField(clazz,"id");

			try {
				
				id = pf.getLong(t);
				
			} catch (IllegalArgumentException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			}
			
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		
		sqlParam.setId(id);
		
		int res = baseDao.update(sqlParam);
		
		return res;
	}

	/*
	 * 部分修改
	 * @see com.ldh.express.base.core.BaseService#update(java.util.Map)
	 * 2019年2月15日
	 */
	@Override
	public int update(Map<String, Object> params) {
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		List<SqlField> fields = new ArrayList<SqlField>();
		
		for(Entry<String, Object> entry : params.entrySet()){
			String key = entry.getKey();		//字段名
			Object value = entry.getValue();	//字段值
			
			value = value == null ? "" : value;
			
			SqlField sqlField = new SqlField();
			sqlField.setFieldName(this.changeName(key));
			sqlField.setFieldValue(value);
			
			fields.add(sqlField);
		}
		
		sqlParam.setFields(fields);
		
		int res = baseDao.update(sqlParam);
		
		return res;
	}

	@Override
	public int delete(long id) {
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		sqlParam.setId(id);
		
		int res = baseDao.delete(sqlParam);
		
		return res;
	}

	/*
	 * 条件删除
	 * @see com.ldh.express.base.core.BaseService#delete(java.util.Map)
	 * 2019年2月15日
	 */
	@Override
	public int delete(Map<String, Object> params) {
		String beanType = this.getBeanType();
		SqlParam sqlParam = getSqlParam(beanType);
		
		List<SqlField> fields = new ArrayList<SqlField>();
		
		for(Entry<String, Object> entry : params.entrySet()){
			String key = entry.getKey();		//字段名
			Object value = entry.getValue();	//字段值
			
			SqlField sqlField = new SqlField();
			sqlField.setFieldName(this.changeName(key));
			sqlField.setFieldValue(value);
			
			fields.add(sqlField);
		}
		
		//条件判断，不允许全部删除
		if(fields.size() == 0){
			return -1;
		}
		
		int res = baseDao.deleteParams(sqlParam);
		
		return res;
	}
	
	
	/**
	 * 获取实体类型
	 * @return
	 */
	public String getBeanType() {
		Type type = this.getClass().getGenericSuperclass();	
		//通过这个方法获取了一个Type对象，里面实际上包含了类的各种基本信息，如成员变量、方法、类名和泛型的信息...
		ParameterizedType pt = (ParameterizedType)type;
		
		Type[] args = pt.getActualTypeArguments();	//这是一包含了所有的泛型类型 信息的个数组

		return args[0].getTypeName();
	}
	
	
	/**
	 * 获取bean名称
	 * @return
	 */
	public String getBeanName() {

		String name = getBeanType();
		
		String[] ar = name.split("\\.");

		return ar.length == 0 ? null : ar[ar.length - 1];
	}

	
	/**
	 * 获取表名
	 * @return
	 */
	public String getTabName(){

		String className = getBeanName();
		
		String tabName = "t" + changeName(className);
		
		return tabName;
	}
	
	/**
	 * 获取表名
	 * @param className
	 * @return
	 */
	public String getTabName(String className){

		String tabName = "t" + changeName(className);
		
		return tabName;
	}
	
	
	/**
	 * 获取参数实体
	 * @param beanType
	 * @return
	 */
	public SqlParam getSqlParam(String beanType){
		SqlParam sqlParam = new SqlParam();
		
		String[] ar = beanType.split("\\.");

		sqlParam.setTableName(getTabName(ar.length == 0 ? null : ar[ar.length - 1]));
		
		return sqlParam;
	}
	
	
	/**
	 * 驼峰转下划线
	 * @param oldname
	 * @return
	 */
	public String changeName(String oldname){
		
		if(oldname == null) throw new MyRunException("驼峰转下划线参数不能为空");
		
		StringBuilder newName = new StringBuilder();
		
		for(int i = 0; i < oldname.length(); i++){
			
			char ch = oldname.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z'){
				newName.append(("_" + ch).toLowerCase());
			}else{
				newName.append(ch);
			}
		}
		
		return newName.toString();
	}
	
	/**
	 * 转驼峰
	 * @param field
	 * @return
	 */
	private String toProperty(String field){
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < field.length(); i++){
			char c = field.charAt(i);
			
			if(c == '_'){
				
				i++;
				sb.append((field.charAt(i) + "").toUpperCase() );
			}else{
				
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 在父类中找属性
	 * @param clazz
	 * @param name
	 * @return
	 */
	public Field getSurperField(Class<?> clazz,String name){
		
		Class<?> pclazz = clazz.getSuperclass();
		
		//到object类
		if("Object".equals(pclazz.getSimpleName())){
			
			return null;
		}
		
		try {
			//查找属性
			Field f = pclazz.getDeclaredField(name);
			
			f.setAccessible(true);
			
			return f;		
			
		} catch (NoSuchFieldException e) {
			
			if("BaseModel".equals(pclazz.getSimpleName())) return null;	//找到基础类之后  跳出递归

			return this.getSurperField(pclazz,name);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/**
	 * 判断是否临时注解
	 * @param f
	 * @return
	 */
	private boolean isTemp(Field f){
		//判断是否存在该注解
		TempField t = f.getAnnotation(TempField.class);
		
		if(t == null){
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 获取返回实体
	 * @return
	 */
	public ServiceResult<T> getSucResult(T t){
		ServiceResult<T > result = new ServiceResult<>();
		
		result.setCode(1);
		result.setObject(t);
		return result;
	}

}
