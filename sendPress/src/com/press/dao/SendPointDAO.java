package com.press.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.press.pojo.SendPoint;

/**
 * A data access object (DAO) providing persistence and search support for
 * SendPoint entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.SendPoint
 * @author MyEclipse Persistence Tools
 */
@Service("SendPointDAO")
public class SendPointDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SendPointDAO.class);
	// property constants
	public static final String SEND_NAME = "sendName";
	public static final String ADDRESS = "address";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String _SID = "SId";
	public static final String _STEL = "STel";
	public static final String TYPE = "type";
	public static final String NEED_NUM = "needNum";

	protected void initDao() {
		// do nothing
	}
	//修改
	 public void update(SendPoint transientInstance) {
	        log.debug("saving SendPoint instance");
	        try {
	            getHibernateTemplate().update(transientInstance);
	            log.debug("save successful");
	        } catch (RuntimeException re) {
	            log.error("save failed", re);
	            throw re;
	        }
	    }

   //多条件查询
	 public List<SendPoint> getByCondition(SendPoint sendPoint){
		 
		      try {
		    	 
		    	  StringBuilder queryString = new StringBuilder("from SendPoint as model where");
		    	  List<Object> lists = new ArrayList<Object>();
						queryString.append(" model.id like '%' ");
					
					if( sendPoint.getSendName() != null && !"".equals( sendPoint.getSendName() ) ) {
						queryString.append(" and model.sendName = ? ");		
						lists.add( sendPoint.getSendName() );
					}
					if( sendPoint.getAddress() != null && !"".equals( sendPoint.getAddress() ) ) {
						queryString.append(" and model.address = ? ");		
						lists.add( sendPoint.getAddress() );
					}
					if( sendPoint.getSId() != null && sendPoint.getSId() != 0 ) {
					queryString.append(" and model.SId = ? ");
					lists.add( sendPoint.getSId() );
					}
					if( sendPoint.getSTel() != null && sendPoint.getSTel() != 0 ) {
						queryString.append(" and model.STel = ? ");
						lists.add( sendPoint.getSTel() );
						}
			
					if( sendPoint.getLongitude() != null && !"".equals( sendPoint.getLongitude() ) ) {
						queryString.append(" and model.longitude = ? ");		
						lists.add( sendPoint.getLongitude() );
					}
					if( sendPoint.getLatitude() != null && !"".equals( sendPoint.getLatitude() ) ) {
						queryString.append(" and model.latitude = ? ");		
						lists.add( sendPoint.getLatitude() );
					}
					if( sendPoint.getType() != null && !"".equals( sendPoint.getType() ) ) {
						queryString.append(" and model.type = ? ");
						lists.add( sendPoint.getType() );
						}
					if( sendPoint.getNeedNum() != null && sendPoint.getNeedNum() != 0 ) {
						queryString.append(" and model.needNum = ? ");
						lists.add( sendPoint.getNeedNum() );
						}
					
				 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
				 
		      } catch (RuntimeException re) {
		         log.error("find by property name failed", re);
		         throw re;
		      }
	 }

	public void save(SendPoint transientInstance) {
		log.debug("saving SendPoint instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SendPoint persistentInstance) {
		log.debug("deleting SendPoint instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SendPoint findById(java.lang.Integer id) {
		log.debug("getting SendPoint instance with id: " + id);
		try {
			SendPoint instance = (SendPoint) getHibernateTemplate().get("com.press.pojo.SendPoint", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SendPoint instance) {
		log.debug("finding SendPoint instance by example");
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
		log.debug("finding SendPoint instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SendPoint as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySendName(Object sendName) {
		return findByProperty(SEND_NAME, sendName);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findBySId(Object SId) {
		return findByProperty(_SID, SId);
	}

	public List findBySTel(Object STel) {
		return findByProperty(_STEL, STel);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByNeedNum(Object needNum) {
		return findByProperty(NEED_NUM, needNum);
	}

	public List findAll() {
		log.debug("finding all SendPoint instances");
		try {
			String queryString = "from SendPoint";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SendPoint merge(SendPoint detachedInstance) {
		log.debug("merging SendPoint instance");
		try {
			SendPoint result = (SendPoint) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SendPoint instance) {
		log.debug("attaching dirty SendPoint instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SendPoint instance) {
		log.debug("attaching clean SendPoint instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SendPointDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SendPointDAO) ctx.getBean("SendPointDAO");
	}
}