package com.press.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.press.pojo.PointRelation;

/**
 * A data access object (DAO) providing persistence and search support for
 * PointRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.press.pojo.PointRelation
 * @author MyEclipse Persistence Tools
 */
@Service("PointRelationDAO")
public class PointRelationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PointRelationDAO.class);
	// property constants
	public static final String PRINT_ID = "printId";
	public static final String SEND_ID = "sendId";

	protected void initDao() {
		// do nothing
	}
	public void update(PointRelation transientInstance) {
		log.debug("saving PointRelation instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		}
		//多条件查询
		 public List<PointRelation> getByCondition(PointRelation pointRelation){

			      try {
			    	 
			    	  StringBuilder queryString = new StringBuilder("from PointRelation as model where");
			    	  List<Object> lists = new ArrayList<Object>();
						//if( pointRelation.getId() != null && pointRelation.getId() != 0 ) {
							queryString.append(" model.id like '%' ");
							//lists.add( pointRelation.getId() );
						//}
					
						if( pointRelation.getPrintId() != null && pointRelation.getPrintId() != 0 ) {
						queryString.append(" and model.printId = ? ");
						lists.add( pointRelation.getPrintId() );
						}
						if( pointRelation.getSendId() != null && pointRelation.getSendId() != 0 ) {
							queryString.append(" and model.sendId = ? ");
							lists.add( pointRelation.getSendId() );
							}
						
						
					 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
					 
			      } catch (RuntimeException re) {
			         log.error("find by property name failed", re);
			         throw re;
			      }
		 }
	
	public void save(PointRelation transientInstance) {
		log.debug("saving PointRelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PointRelation persistentInstance) {
		log.debug("deleting PointRelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PointRelation findById(java.lang.Integer id) {
		log.debug("getting PointRelation instance with id: " + id);
		try {
			PointRelation instance = (PointRelation) getHibernateTemplate().get("com.press.pojo.PointRelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PointRelation instance) {
		log.debug("finding PointRelation instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PointRelation instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from PointRelation as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrintId(Object printId) {
		return findByProperty(PRINT_ID, printId);
	}

	public List findBySendId(Object sendId) {
		return findByProperty(SEND_ID, sendId);
	}

	public List findAll() {
		log.debug("finding all PointRelation instances");
		try {
			String queryString = "from PointRelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PointRelation merge(PointRelation detachedInstance) {
		log.debug("merging PointRelation instance");
		try {
			PointRelation result = (PointRelation) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PointRelation instance) {
		log.debug("attaching dirty PointRelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PointRelation instance) {
		log.debug("attaching clean PointRelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PointRelationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PointRelationDAO) ctx.getBean("PointRelationDAO");
	}
}