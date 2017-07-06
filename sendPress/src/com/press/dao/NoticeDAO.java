package com.press.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.press.pojo.Notice;

/**
 * A data access object (DAO) providing persistence and search support for
 * Notice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.press.pojo.Notice
 * @author MyEclipse Persistence Tools
 */
@Repository("noticeDao")
public class NoticeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NoticeDAO.class);
	// property constants
	public static final String FROM_MAN = "fromMan";
	public static final String TO_MAN = "toMan";
	public static final String CONTENT = "content";
	public static final String READSTATE = "readstate";

	protected void initDao() {
		// do nothing
	}

	public void save(Notice transientInstance) {
		log.debug("saving Notice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(Notice persistentInstance) {
		log.debug("updating Notice instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void delete(Notice persistentInstance) {
		log.debug("deleting Notice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Notice findById(java.lang.Integer id) {
		log.debug("getting Notice instance with id: " + id);
		try {
			Notice instance = (Notice) getHibernateTemplate().get(
					"com.press.pojo.Notice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Notice instance) {
		log.debug("finding Notice instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Notice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Notice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByProperty2(int id, int state) {

		try {
			String queryString = "from Notice as model where model.toMan = ? and model.readstate = ?";
			return getHibernateTemplate().find(queryString, id, state);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFromMan(Object fromMan) {
		return findByProperty(FROM_MAN, fromMan);
	}

	public List findByToMan(Object toMan) {
		return findByProperty(TO_MAN, toMan);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByReadstate(Object readstate) {
		return findByProperty(READSTATE, readstate);
	}

	public List findAll() {
		log.debug("finding all Notice instances");
		try {
			String queryString = "from Notice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Notice merge(Notice detachedInstance) {
		log.debug("merging Notice instance");
		try {
			Notice result = (Notice) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Notice instance) {
		log.debug("attaching dirty Notice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notice instance) {
		log.debug("attaching clean Notice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NoticeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NoticeDAO) ctx.getBean("NoticeDAO");
	}
}