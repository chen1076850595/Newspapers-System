package com.press.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.press.pojo.Staff;


@SuppressWarnings("unused")
public class BaseHqlDaoImpl implements BaseHqlDao{
	
    // 执行持久化操作的HibernateTemplate  
    HibernateTemplate ht;  
    SessionFactory sessionFactory;  
    //依赖注入SessionFactory 的必需的setter 方法  
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
     
    //该方法用于完成HibernateTemplate的初始化  
    public void setHibernateTemplate() {  
         if (ht ==null){  
            ht = new HibernateTemplate(sessionFactory);  
        }  
    }
    
    @Override
    public void save(Object object) {
    	setHibernateTemplate();
    	System.out.println( object );
    	try {
    		ht.save(object);
    		System.out.println("保存成功");
    	} catch (Exception e) {
    		System.out.println("保存失败");
    		e.printStackTrace();
    	} 
    }
    
    @Override
    public Object findById( String table,Integer id) {

		try {
			setHibernateTemplate();
			Object instance = ht.get( table, id );
			return instance;
		} catch (RuntimeException re) {
			System.err.println("get failed " + re);
			throw re;
		}
    }
    @Override
    public List findByExample(Object object) {

		try {
			setHibernateTemplate();
			List results = ht.findByExample( object );
			System.out.println("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed" + re);
			throw re;
		}
    }
    
    @Override
    public void update(Object object) {
   
		try {
			setHibernateTemplate();
			ht.update( object );
			System.out.println("update successful"); 
		} catch (RuntimeException re) {
			System.err.println("update failed" + re);
			throw re;
		}
    	
    }
    
    @Override
    public void delete(Object object) {

		try {
			setHibernateTemplate();
			ht.delete( object );
			System.out.println("delete successful");
		} catch (RuntimeException re) {
			System.err.println("detele failed" + re);
			throw re;
		}
    	
    }
    
    @Override
    public Object merge(Object detachedInstance) {
    	
		try {
			setHibernateTemplate();
			Object result = ht.merge( detachedInstance );
			System.out.println("merge successful");
			return result;
		} catch (RuntimeException re) {
			System.err.println("merge failed" + re);
			throw re;
		}
    }
    
    @Override
    public void attachDirty(Object instance) {
    	
		try {
			setHibernateTemplate();
			ht.saveOrUpdate(instance);
			System.out.println("attach successful");
		} catch (RuntimeException re) {
			System.err.println("attach failed" + re);
			throw re;
		}
    	
    }
    
    @Override
    public void attachClean(Object instance) {

		try {
			setHibernateTemplate();
			ht.lock(instance, LockMode.NONE);
			System.out.println("attach successful");
		} catch (RuntimeException re) {
			System.err.println("attach failed" + re );
			throw re;
		}
    	
    }

	@Override
	public List findAll(String entity) {
		
		try {
			setHibernateTemplate();
			String queryString = "from " + entity;
			return ht.find(queryString);
		} catch (RuntimeException re) {
			System.err.println("find all failed" + re);
			throw re;
		}
	}
}
//	/************************* 执行Query **********************************/
//	public List<?> aboutGetList(Query query){
//		List<?> list = null;
//		try {
//			list = query.list();
//			System.out.println( list );
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		} finally{
////			session.close();
//		}
//		return list;
//	}
//	public Object aboutGetObject(Query query){
//		Object object = null;
//		try {
//			object = query.uniqueResult();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		} finally {
////			session.close();
//		}
//		return object;
//	}
//	public boolean aboutUpdate(Query query){
////		Transaction tran = session.beginTransaction();
//		getHibernateTemplate().
//		Boolean result = false;
//		try {
//			query.executeUpdate();
//			tran.commit();
//			result = true;
//		} catch (HibernateException e) {
//			if (tran != null) {
//				tran.rollback();
//			}
//			e.printStackTrace();
//		} finally {
////			session.close();
//		}
//		return result;
//	}
//	//设置参数
//	public Query setParameter(Query query,Object[] param){
//		if(param == null)
//			return query;
//		for(int i=0;i<param.length;i++)
//			query.setParameter("param"+i, param[i]);
//		return query;
//	}
//	
//	/************************* Hql查询 **********************************/
//	@Override
//	public Object get(java.lang.Class<?> c, String id) {
//		return session.get(c, id);
//	}
//	@Override
//	public List<?> getList(String hql) {
//		Query query = session.createQuery(hql);
//		return aboutGetList(query);
//	}
//	@Override
//	public Object getObject(String hql) {
//		Query query = session.createQuery(hql);
//		return aboutGetObject(query);
//	}
//	@Override
//	public boolean getBoolean(String hql) {
//		Query query = session.createQuery(hql);
//		if(aboutGetList(query).isEmpty())
//			return true;
//		return false;
//	}
//	@Override
//	public int getCount(String hql) {
//		Query query = session.createQuery(hql);
//		return aboutGetList(query).size();
//	}
//
//	/************************* Hql增加**********************************/
//	@Override
//	public boolean saveItem(String hql) {
//		Query query = session.createSQLQuery(hql);
//		if(aboutUpdate(query))
//			return true;
//		return false;
//	}
//
//	/************************* Hql删除 **********************************/
//	@Override
//	public boolean delete(Object object) {
//		Transaction tran = session.beginTransaction();
//		boolean result = false;
//		try {
//			session.delete(object);
//			tran.commit();
//			result = true;
//		} catch (HibernateException e) {
//			tran.rollback();
//		} finally {
//			session.close();
//		}
//		return result;
//	};
//	@Override
//	public boolean deleteItem(String hql) {
//		return saveItem(hql);
//	}
//
//	/************************* Hql更新 **********************************/
//	@Override
//	public boolean update(Object object) {
//		Transaction tran = session.beginTransaction();
//		boolean result = false;
//		try {
//			session.update(object);
//			tran.commit();
//			result = true;
//		} catch (Exception e) {
//			if (tran != null) {
//				tran.rollback();
//			}
//		}
//		return result;
//	}
//	public boolean updateItem(String hql){
//		return saveItem(hql);
//	}
//
//	/************************* Hql分页 **********************************/
//	@Override
//	public int getAllRowCount(String hql) {
//		return getCount(hql);
//	}
//	@Override
//	public List<?> queryByPage(String hql, int offset, int pageSize) {
//		Query query = session.createQuery(hql);
//		query.setFirstResult(offset).setMaxResults(pageSize);
//		return aboutGetList(query);
//	}
//	
//	/*************************自定义查询**********************************/
//	@Override
//	public Object getUniqueObject(String target, String table, String[] field,
//			Object[] param) {
//		String hql = getHqlFromSelect(target) + getHqlFromArray(table, field, param);
//		Query query = session.createQuery(hql);
//		return aboutGetObject(setParameter(query, param));
//	}
//	@Override
//	public List<?> getObjects(String[] target, String table, String[] field,
//			Object[] param) {
//		String hql = getHqlFromSelect(target) + getHqlFromArray(table, field, param);
//		Query query = session.createQuery(hql);
//		return aboutGetList(setParameter(query, param));
//	}
//	@Override
//	public List<?> getItem(String table, String[] field, Object[] param) {
//		String hql = getHqlFromArray(table, field, param);
//		Query query = session.createQuery(hql);
//		return aboutGetList(setParameter(query, param));
//	}
//	@Override
//	public List<?> getItemOrderBy(String[] target, String table, String[] field,
//			Object[] param, String order, String sort){
//		String hql = getHqlFromSelect(target) + getHqlFromArray(table, field, param) + getHqlFromOrderBy(order,sort);
//		Query query = session.createQuery(hql);
//		query.setParameter("order", order);
//		return aboutGetList(setParameter(query, param));
//	}
//	@Override
//	public boolean isExist(String table, String[] field, Object[] param) {
//		if(!getItem(table, field, param).isEmpty()) {
//			System.out.println("存在");
//			return true;
//		}
//		System.out.println("不存在");
//		return false;
//	}
//	@Override
//	public List<?> getLikeObjects(String table, String field, String param) {
//		String hql = getHqlFromLike( table, field, param );
//		Query query = session.createQuery( hql );
//		return aboutGetList(query);
//	}
//	
//	/************************* 自定义添加 **********************************/
//	public boolean saveItem(String table, String[] field, Object[] param) {
//		String hql = getSaveHql(table, field, param);
//		Query query = session.createSQLQuery(hql);
//		return aboutUpdate(query);
//	};
//	
//	/************************* 自定义删除**********************************/
//	public boolean deleteItem(String table, String[] field, Object[] param) {
//		String hql = "delete " + getHqlFromArray(table, field, param);
//		Query query = session.createQuery(hql);
//		return aboutUpdate(setParameter(query, param));
//	};
//	@Override
//	public boolean deleteAllItem(String table) {
//		String hql = "delete " + table;
//		Query query = session.createQuery(hql);
//		return aboutUpdate(query);
//	}
//
//	/************************* 自定义更新 **********************************/
//	public boolean updateItem(String table, String[] field1, Object[] param1, String[] field2, Object[] param2) {
//		String hql = getUpdateHql(table, field1, param1, field2, param2);
//		Query query = session.createSQLQuery(hql);
//		return aboutUpdate(setParameter(query, param1));
//	};
//	
//	/************************* HQL拼接工具 **********************************/
//	private String getHqlFromArray(String table, String[] field, Object[] param) {
//		String hql = " from " + table +" as " + table;
//		if (field == null)
//			return hql;
//		for (int i = 0; i < field.length; i++) {
//			String fieldValue = field[i];
//			if (fieldValue != null) {
//				if (i == 0) {
//					hql += " where " + fieldValue + "=:param"+i+" ";
//				} else {
//					hql += "and " + fieldValue + "=:param"+i+" ";
//				}
//			}
//		}
//		return hql;
//	}
//	private String getHqlFromSelect(Object obj){
//		if(null == obj || obj.equals(""))
//			return "";
//		String hql = "select ";
//		if(obj instanceof String)
//			hql += obj;
//		else if(obj instanceof String[]){
//			String[] str = (String[]) obj;
//			for (int i = 0; i < str.length; i++) {
//				if(i==0)
//					hql += str[i];
//				else
//					hql += "," + str[i];
//			}
//		}
//		return hql;
//	}
//	private String getHqlFromOrderBy(String order, String sort) {		
//		if (order == null)
//			return null;
//		return " order by :order " + sort;
//	}
//	private String getHqlFromBetween(String fieldB, Object from, Object to){	
//		if (fieldB == null)
//			return null;
//		return  " "+ fieldB + " between '"+ from +"' and '" + to + "'"; 
//	}
//	private String getHqlFromLike(String table,String fieldL, String like){
//		if (fieldL == null)
//			return null;
//		return "from " + table + " where " + fieldL + " like '%" + like + "%'";
//	}
//	
//	private String getSaveHql(String table, String[] field, Object[] param){
//		String hql = "insert into " + table;
//		String fieldBlock = "";
//		String paramBlock = "";
//		for (int i = 0; i < field.length; i++) {
//			String fieldValue = field[i];
//			Object paramValue = param[i];
//			// 需要对个数进行判断
//			if (field.length == 1) {
//				fieldBlock += " (" + fieldValue + ") ";
//				paramBlock += " ('" + paramValue + "') ";
//			} else if (field.length == 2) {
//				if (i == 0) {
//					fieldBlock += " (" + fieldValue + ",";
//					paramBlock += " ('" + paramValue + "','";
//				} else {
//					fieldBlock += fieldValue + ") ";
//					paramBlock += paramValue + "')";
//				}
//			} else {
//				if (i == 0) {
//					fieldBlock += " (" + fieldValue;
//					paramBlock += " ('" + paramValue;
//				} else if (i == (field.length - 1)) {
//					fieldBlock +=  ","+fieldValue + ") ";
//					paramBlock += "','" + paramValue + "') ";
//				} else {
//					fieldBlock += "," + fieldValue ;
//					paramBlock += "','" + paramValue;
//				}
//			}
//		}
//		hql += fieldBlock + "values" + paramBlock;
//		return hql;
//	}
//	private String getUpdateHql(String table, String[] field1, Object[] param1, String[] field2, Object[] param2){
//		String hql = "update " + table + " as " + table;
//		if (field1 == null)
//			return hql;
//		for (int i = 0; i < field1.length; i++) {
//			String field1Value = field1[i];
//			if (field1Value != null) {
//				if (i == 0)
//					hql += " set " + table + "." + field1Value + "= :param" + i ;
//				else 
//					hql += "," + table + "." + field1Value + "= :param" + i ;
//			}
//		}
//		if (field2 == null)
//			return hql;
//		for (int i = 0; i < field2.length; i++) {
//			String field2Value = field2[i];
//			Object param2Value = param2[i];
//			if (field2Value != null) {
//				if (i == 0) {
//					hql += " where " + table + "." + field2Value + "=" + " '"
//							+ param2Value + "' ";
//				} else {
//					hql += " and " + table + "." + field2Value + "=" + " '"
//							+ param2Value + "' ";
//				}
//			}
//		}
//		return hql;
//	}
//}
