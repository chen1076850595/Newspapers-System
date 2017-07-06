package com.press.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.press.pojo.Department;

/**
 * A data access object (DAO) providing persistence and search support for
 * Department entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.Department
 * @author MyEclipse Persistence Tools
 */
@Repository("departmentDao")
public class DepartmentDAO extends BaseHqlDaoImpl{
	private static final Logger log = LoggerFactory
			.getLogger(DepartmentDAO.class);
	// property constants
	public static final String _DNAME = "DName";
	public static final String _DTEL = "DTel";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Department instance with property: " + propertyName
				+ ", value: " + value);
		try {
			setHibernateTemplate();
			String queryString = "from Department as model where model."
					+ propertyName + "= ?";
			return ht.find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDName(Object DName) {
		return findByProperty(_DNAME, DName);
	}

	public List findByDTel(Object DTel) {
		return findByProperty(_DTEL, DTel);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}


	public static DepartmentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DepartmentDAO) ctx.getBean("DepartmentDAO");
	}
}