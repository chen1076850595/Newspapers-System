package com.press.dao;

import java.util.List;

public interface BaseHqlDao {
	
	/************************* 查询数据 **********************************/
	public Object findById( String table,Integer id );
	public List findByExample( Object object );
	public List findAll( String table );

	/************************* 增加数据 **********************************/	
	public void save(Object object);

	/************************* 删除数据 **********************************/
	public void delete(Object object);
	
	/************************* 修改数据 **********************************/
	public void update(Object object);
	
	
	/*************************持久化**************************************/
	/** 
	* 将传入的detached状态的对象的属性复制到持久化对象中，并返回该持久化对象。 
	* 如果该session中没有关联的持久化对象，加载一个，如果传入对象未保存，保存一个副本并作为持久对象返回，传入对象依然保持detached状态。 
	*/ 
	public Object merge( Object detachedInstance );
	/** 
	* 将传入的对象持久化并保存。 
	* 如果对象未保存（Transient状态），调用save方法保存。如果对象已保存（Detached状态），调用update方法将对象与Session重新关联。 
	*/ 
	public void attachDirty( Object instance );
	/** 
	* 将传入的对象状态设置为Transient状态 
	*/  
	public void attachClean( Object instance );
}
