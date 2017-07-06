package com.press.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.press.pojo.Jurisdiction;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jurisdiction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.press.pojo.Jurisdiction
 * @author MyEclipse Persistence Tools
 */
@Repository("jurDao")
public class JurisdictionDAO extends BaseHqlDaoImpl {
	private static final Logger log = LoggerFactory
			.getLogger(JurisdictionDAO.class);
	// property constants
	public static final String DESCRIPTION = "description";
	public static final String LEVEL = "level";
	
	protected void initDao() {
		// do nothing
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Jurisdiction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			setHibernateTemplate();
			String queryString = "from Jurisdiction as model where model."
					+ propertyName + "= ?";
			return ht.find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public static JurisdictionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (JurisdictionDAO) ctx.getBean("JurisdictionDAO");
	}
}