package com.press.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.press.pojo.GroupRoad;
import com.press.pojo.Road;
import com.press.pojo.GroupRoad;

/**
 * A data access object (DAO) providing persistence and search support for
 * GroupRoad entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.GroupRoad
 * @author MyEclipse Persistence Tools
 */
@Service("GroupRoadDAO")
public class GroupRoadDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GroupRoadDAO.class);
	// property constants
	public static final String START_POINT = "startPoint";
	public static final String END_POINT = "endPoint";
	public static final String BUS_ID = "busId";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}
	//修改
		 public void update(GroupRoad groupRoad) {
		        log.debug("saving GroupRoad instance");
		        try {
		            getHibernateTemplate().update(groupRoad);
		            log.debug("save successful");
		        } catch (RuntimeException re) {
		            log.error("save failed", re);
		            throw re;
		        }
		    }
			//多条件查询
		 public List<GroupRoad> getByCondition(GroupRoad groupRoad){
//			  setHibernateTemplate(hTemplate);
			  
			
			      try {
			    	 
			    	  StringBuilder queryString = new StringBuilder("from GroupRoad as model where");
			    	  List<Object> lists = new ArrayList<Object>();
						//if( Road.getId() != null && Road.getId() != 0 ) {
							queryString.append(" model.id like '%' ");
							//lists.add( Road.getId() );
						//}
						if( groupRoad.getStartPoint()!= null && !"".equals( groupRoad.getStartPoint() ) ) {
							queryString.append(" and model.startPoint = ? ");		
							lists.add( groupRoad.getStartPoint() );
						}
						if( groupRoad.getEndPoint()!= null && !"".equals( groupRoad.getEndPoint() ) ) {
							queryString.append(" and model.endPoint = ? ");		
							lists.add( groupRoad.getEndPoint() );
						}
						if( groupRoad.getArriveTime()!= null && !"".equals( groupRoad.getArriveTime() ) ) {
							queryString.append(" and model.arriveTime = ? ");		
							lists.add( groupRoad.getArriveTime() );
						}
						
						
						if( groupRoad.getState() != null && groupRoad.getState() != 0 ) {
							queryString.append(" and model.state = ? ");
							lists.add( groupRoad.getState() );
							}
						System.out.println("sb" + queryString.toString());	
						
					 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
					 
			      } catch (RuntimeException re) {
			         log.error("find by property name failed", re);
			         throw re;
			      }
		 }

	
	public void save(GroupRoad transientInstance) {
		log.debug("saving GroupRoad instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GroupRoad persistentInstance) {
		log.debug("deleting GroupRoad instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GroupRoad findById(java.lang.Integer id) {
		log.debug("getting GroupRoad instance with id: " + id);
		try {
			GroupRoad instance = (GroupRoad) getHibernateTemplate().get("com.press.pojo.GroupRoad", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GroupRoad instance) {
		log.debug("finding GroupRoad instance by example");
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
		log.debug("finding GroupRoad instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from GroupRoad as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStartPoint(Object startPoint) {
		return findByProperty(START_POINT, startPoint);
	}

	public List findByEndPoint(Object endPoint) {
		return findByProperty(END_POINT, endPoint);
	}

	public List findByBusId(Object busId) {
		return findByProperty(BUS_ID, busId);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all GroupRoad instances");
		try {
			String queryString = "from GroupRoad";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GroupRoad merge(GroupRoad detachedInstance) {
		log.debug("merging GroupRoad instance");
		try {
			GroupRoad result = (GroupRoad) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GroupRoad instance) {
		log.debug("attaching dirty GroupRoad instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GroupRoad instance) {
		log.debug("attaching clean GroupRoad instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GroupRoadDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GroupRoadDAO) ctx.getBean("GroupRoadDAO");
	}
}