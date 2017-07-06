package com.press.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.press.pojo.PrintPoint;

/**
 * A data access object (DAO) providing persistence and search support for
 * PrintPoint entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.PrintPoint
 * @author MyEclipse Persistence Tools
 */
@Service("PrintPointDAO")
public class PrintPointDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PrintPointDAO.class);
	// property constants
	public static final String PRINT_NAME = "printName";
	public static final String PRINT_ADDRESS = "printAddress";
	public static final String _SID = "SId";
	public static final String _STEL = "STel";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";

	protected void initDao() {
		// do nothing
	}
	//修改
		 public void update(PrintPoint transientInstance) {
		        log.debug("saving printPoint instance");
		        try {
		            getHibernateTemplate().update(transientInstance);
		            log.debug("save successful");
		        } catch (RuntimeException re) {
		            log.error("save failed", re);
		            throw re;
		        }
		    }

	    //多条件查询
		 public List<PrintPoint> getByCondition(PrintPoint printPoint){
			 
			      try {
			    	 
			    	  StringBuilder queryString = new StringBuilder("from PrintPoint as model where");
			    	  List<Object> lists = new ArrayList<Object>();
						//if( printPoint.getId() != null && printPoint.getId() != 0 ) {
							queryString.append(" model.id like '%' ");
							//lists.add( printPoint.getId() );
						//}
						if( printPoint.getPrintName() != null && !"".equals( printPoint.getPrintName() ) ) {
							queryString.append(" and model.printName = ? ");		
							lists.add( printPoint.getPrintName() );
						}
						if( printPoint.getPrintAddress() != null && !"".equals( printPoint.getPrintAddress() ) ) {
							queryString.append(" and model.printAddress = ? ");		
							lists.add( printPoint.getPrintAddress() );
						}
						if( printPoint.getSId() != null && printPoint.getSId() != 0 ) {
						queryString.append(" and model.SId = ? ");
						lists.add( printPoint.getSId() );
						}
						if( printPoint.getSTel() != null && printPoint.getSTel() != 0 ) {
							queryString.append(" and model.STel = ? ");
							lists.add( printPoint.getSTel() );
							}
				
						if( printPoint.getLongitude() != null && !"".equals( printPoint.getLongitude() ) ) {
							queryString.append(" and model.longitude = ? ");		
							lists.add( printPoint.getLongitude() );
						}
						if( printPoint.getLatitude() != null && !"".equals( printPoint.getLatitude() ) ) {
							queryString.append(" and model.latitude = ? ");		
							lists.add( printPoint.getLatitude() );
						}
						System.out.println(queryString.toString());
					 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
					 
			      } catch (RuntimeException re) {
			         log.error("find by property name failed", re);
			         throw re;
			      }
		 }
	public void save(PrintPoint transientInstance) {
		log.debug("saving PrintPoint instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PrintPoint persistentInstance) {
		log.debug("deleting PrintPoint instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PrintPoint findById(java.lang.Integer id) {
		log.debug("getting PrintPoint instance with id: " + id);
		try {
			PrintPoint instance = (PrintPoint) getHibernateTemplate().get("com.press.pojo.PrintPoint", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PrintPoint instance) {
		log.debug("finding PrintPoint instance by example");
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
		log.debug("finding PrintPoint instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from PrintPoint as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrintName(Object printName) {
		return findByProperty(PRINT_NAME, printName);
	}

	public List findByPrintAddress(Object printAddress) {
		return findByProperty(PRINT_ADDRESS, printAddress);
	}

	public List findBySId(Object SId) {
		return findByProperty(_SID, SId);
	}

	public List findBySTel(Object STel) {
		return findByProperty(_STEL, STel);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findAll() {
		log.debug("finding all PrintPoint instances");
		try {
			String queryString = "from PrintPoint";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PrintPoint merge(PrintPoint detachedInstance) {
		log.debug("merging PrintPoint instance");
		try {
			PrintPoint result = (PrintPoint) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PrintPoint instance) {
		log.debug("attaching dirty PrintPoint instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PrintPoint instance) {
		log.debug("attaching clean PrintPoint instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PrintPointDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PrintPointDAO) ctx.getBean("PrintPointDAO");
	}
}