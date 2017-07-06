package com.press.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.property.Setter;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.press.pojo.ChangeLevel;
import com.press.pojo.Staff;
import com.press.pojo.changeJop;

/**
 * A data access object (DAO) providing persistence and search support for Staff
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.press.pojo.Staff
 * @author MyEclipse Persistence Tools
 */
@Repository("staffDao")
public class StaffDAO extends BaseHqlDaoImpl{
	
  
	private static final Logger log = LoggerFactory.getLogger(StaffDAO.class);
	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String USERNAME = "username";
	public static final String TEL = "tel";
	public static final String DNO = "dno";
	public static final String LEVEL = "level";
	public static final String JOP = "jop";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Staff instance with property: " + propertyName
				+ ", value: " + value);
		try {
			setHibernateTemplate();
			String queryString = "from Staff as model where model."
					+ propertyName + "= ?";
			return ht.find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//根据多条件查找员工的基本信息
	public List findByProperty2( Staff staff ) {
		try {
			setHibernateTemplate();
			String hql = "from Staff as model where";
			StringBuilder queryString = new StringBuilder(hql);
			List<Object> lists = new ArrayList<Object>();
			//勾了ID的情况
			if( staff.getId() != null && staff.getId() != 0 ) {
				queryString.append(" model.id = ?");
				lists.add( staff.getId() );
			}
			//没勾ID的情况
			if( staff.getId() == null ) {
				queryString.append(" model.id like '%'");
			}
			if( staff.getAccount() != null && !"".equals( staff.getAccount() ) ) {
				queryString.append(" and model.account = ?");		
				lists.add( staff.getAccount() );
			}
//			if( staff.getPassword() != null && !"".equals( staff.getPassword() ) ) {
//				queryString.append(" and model.password = ?");		
//				lists.add( staff.getPassword() );
//			}
			if( staff.getUsername() != null && !"".equals( staff.getUsername() ) ) {
				queryString.append(" and model.username = ?");
				lists.add( staff.getUsername() );
			}
			if( staff.getBirthday() != null ) {
				queryString.append(" and model.birthday = ?");
				lists.add( staff.getBirthday() );
			}	
			if( staff.getTel() != null && staff.getTel() != 0 ) {
				queryString.append(" and model.tel = ?");
				lists.add( staff.getTel() );
			}
			if( staff.getDno() != null && !"".equals( staff.getDno() ) ) {
				queryString.append(" and model.dno = ?");
				lists.add( staff.getDno() );
			}
			if( staff.getLevel() != null && staff.getLevel() != 0 ) {
				queryString.append(" and model.level = ?");
				lists.add( staff.getDno() );
			}
			if( staff.getJop() != null && !"".equals( staff.getJop() ) ) {
				queryString.append(" and model.jop = ?");
				lists.add( staff.getJop() );
			}	
			if( staff.getRegdate() != null ) {
				queryString.append(" and model.regdate = ?");
				lists.add( staff.getRegdate() );
			}
			if( staff.getState() != null ) {
				queryString.append(" and model.state = ?");
				lists.add( staff.getState() );
			}
			
			return ht.find( queryString.toString(), lists.toArray() );
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//根据ID和密码来查询用户
	public List<Staff> findByIdAndPassword(int id, String password) {
		setHibernateTemplate();
		String queryString = "from Staff as model where model.id = ? and model.password = ?";
		System.out.println( id );
		return ht.find( queryString, id, password );
	}
	//多表查询（查询了部门）
	public List<changeJop> findByProperty3(changeJop jop2) {

		try {
			setHibernateTemplate();
			//必须给出完整类名
			String hql = "select new com.press.pojo.changeJop(staff.id, staff.username, department.DName, staff.jop) " +
					"from Staff as staff, Department as department where";
			StringBuilder queryString = new StringBuilder(hql);
			List<Object> lists = new ArrayList<Object>();
			//勾了ID的情况
			if(jop2.getSno() == null) {
				queryString.append(" staff.id like '%'");				
			}
			if(jop2.getSno() != null && jop2.getSno() != 0) {
				queryString.append(" staff.id = ?");
				lists.add( jop2.getSno() );
			}	
			if(jop2.getSname() != null && !"".equals(jop2.getSname())) {
				queryString.append(" staff.username = ?");
				lists.add( jop2.getSname() );				
			}
			if(jop2.getDname() != null && !"".equals(jop2.getDname())) {
				queryString.append(" department.DName = ?");
				lists.add( jop2.getDname() );				
			}
			if(jop2.getDjop() != null && !"".equals(jop2.getDjop())) {
				queryString.append(" staff.jop = ?");
				lists.add( jop2.getDjop() );				
			}
			queryString.append(" and staff.dno = department.DNo");
			return ht.find( queryString.toString(), lists.toArray() );
		}catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}
	public List<ChangeLevel> findByProperty4(ChangeLevel c) {

		try {
			setHibernateTemplate();
			//必须给出完整类名
			String hql = "select new com.press.pojo.ChangeLevel(staff.id, staff.username, jurisdiction.level, jurisdiction.description) " +
					"from Staff as staff, Jurisdiction as jurisdiction where";
			StringBuilder queryString = new StringBuilder(hql);
			List<Object> lists = new ArrayList<Object>();
			//勾了ID的情况
			if( c.getSno() == null) {
				queryString.append(" staff.id like '%'");				
			}
			if( c.getSno() != null && c.getSno() != 0) {
				queryString.append(" staff.id = ? ");
				lists.add( c.getSno() );
			}	
			if( c.getSname() != null && !"".equals(c.getSname())) {
				queryString.append(" staff.username = ?");
				lists.add( c.getSname() );				
			}
			if(c.getLdescription()!= null && !"".equals(c.getLdescription())) {
				queryString.append(" jurisdiction.description = ?");
				lists.add( c.getLdescription() );				
			}
			queryString.append(" and staff.level = jurisdiction.level");
			return ht.find( queryString.toString(), lists.toArray() );
		}catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}
	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}
	
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByDno(Object dno) {
		return findByProperty(DNO, dno);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByJop(Object jop) {
		return findByProperty(JOP, jop);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public static StaffDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StaffDAO) ctx.getBean("StaffDAO");
	}


}