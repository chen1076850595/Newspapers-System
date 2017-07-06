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

import com.press.pojo.Road;
import com.press.pojo.Road;

/**
 	* A data access object (DAO) providing persistence and search support for Road entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.press.pojo.Road
  * @author MyEclipse Persistence Tools 
 */
@Service("RoadDAO")
public class RoadDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RoadDAO.class);
		//property constants
	public static final String START_ADDR = "startAddr";
	public static final String END_ADDR = "endAddr";
	public static final String BUS_ID = "busId";
	public static final String STATE = "state";



	protected void initDao() {
		//do nothing
	}
	//修改
		 public void update(Road road) {
		        log.debug("saving Road instance");
		        try {
		            getHibernateTemplate().update(road);
		            log.debug("save successful");
		        } catch (RuntimeException re) {
		            log.error("save failed", re);
		            throw re;
		        }
		    }

	    //多条件查询
		 public List<Road> getByCondition(Road road){
//			  setHibernateTemplate(hTemplate);
			  
			
			      try {
			    	 
			    	  StringBuilder queryString = new StringBuilder("from Road as model where");
			    	  List<Object> lists = new ArrayList<Object>();
						//if( Road.getId() != null && Road.getId() != 0 ) {
							queryString.append(" model.id like '%' ");
							//lists.add( Road.getId() );
						//}
						if( road.getStartAddr()!= null && !"".equals( road.getStartAddr() ) ) {
							queryString.append(" and model.startAddr = ? ");		
							lists.add( road.getStartAddr() );
						}
						if( road.getEndAddr()!= null && !"".equals( road.getEndAddr() ) ) {
							queryString.append(" and model.endAddr = ? ");		
							lists.add( road.getEndAddr() );
						}
						if( road.getArriveTime()!= null && !"".equals( road.getArriveTime() ) ) {
							queryString.append(" and model.arriveTime = ? ");		
							lists.add( road.getArriveTime() );
						}
						
						if( road.getBusId() != null && road.getBusId() != 0 ) {
						queryString.append(" and model.busId = ? ");
						lists.add( road.getBusId() );
						}
						if( road.getState() != null && road.getState() != 0 ) {
							queryString.append(" and model.state = ? ");
							lists.add( road.getState() );
							}
							
						
					 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
					 
			      } catch (RuntimeException re) {
			         log.error("find by property name failed", re);
			         throw re;
			      }
		 }
    public void save(Road transientInstance) {
        log.debug("saving Road instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Road persistentInstance) {
        log.debug("deleting Road instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Road findById( java.lang.Integer id) {
        log.debug("getting Road instance with id: " + id);
        try {
            Road instance = (Road) getHibernateTemplate()
                    .get("com.press.pojo.Road", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Road instance) {
        log.debug("finding Road instance by example");
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
      log.debug("finding Road instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Road as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByStartAddr(Object startAddr
	) {
		return findByProperty(START_ADDR, startAddr
		);
	}
	
	public List findByEndAddr(Object endAddr
	) {
		return findByProperty(END_ADDR, endAddr
		);
	}
	
	public List findByBusId(Object busId
	) {
		return findByProperty(BUS_ID, busId
		);
	}
	
	public List findByState(Object state
	) {
		return findByProperty(STATE, state
		);
	}
	

	public List findAll() {
		log.debug("finding all Road instances");
		try {
			String queryString = "from Road";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Road merge(Road detachedInstance) {
        log.debug("merging Road instance");
        try {
            Road result = (Road) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Road instance) {
        log.debug("attaching dirty Road instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Road instance) {
        log.debug("attaching clean Road instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RoadDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RoadDAO) ctx.getBean("RoadDAO");
	}
}