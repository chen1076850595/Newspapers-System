package com.press.pojo;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bundle entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.Bundle
 * @author MyEclipse Persistence Tools
 */
public class BundleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BundleDAO.class);
	// property constants
	public static final String BUNDLE_NUM = "bundleNum";
	public static final String PRINT_ID = "printId";

	protected void initDao() {
		// do nothing
	}

	public void save(Bundle transientInstance) {
		log.debug("saving Bundle instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bundle persistentInstance) {
		log.debug("deleting Bundle instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bundle findById(java.lang.Integer id) {
		log.debug("getting Bundle instance with id: " + id);
		try {
			Bundle instance = (Bundle) getHibernateTemplate().get("com.press.pojo.Bundle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bundle instance) {
		log.debug("finding Bundle instance by example");
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
		log.debug("finding Bundle instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Bundle as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBundleNum(Object bundleNum) {
		return findByProperty(BUNDLE_NUM, bundleNum);
	}

	public List findByPrintId(Object printId) {
		return findByProperty(PRINT_ID, printId);
	}

	public List findAll() {
		log.debug("finding all Bundle instances");
		try {
			String queryString = "from Bundle";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bundle merge(Bundle detachedInstance) {
		log.debug("merging Bundle instance");
		try {
			Bundle result = (Bundle) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bundle instance) {
		log.debug("attaching dirty Bundle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bundle instance) {
		log.debug("attaching clean Bundle instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BundleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BundleDAO) ctx.getBean("BundleDAO");
	}
}