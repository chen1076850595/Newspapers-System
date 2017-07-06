package com.press.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import com.press.pojo.Newspaper;

/**
 	* A data access object (DAO) providing persistence and search support for Newspaper entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.press.pojo.Newspaper
  * @author MyEclipse Persistence Tools 
 */
@Service("NewspaperDAO")
public class NewspaperDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(NewspaperDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String PAGE_NUM = "pageNum";
	public static final String PAGE_LENGTH = "pageLength";
	public static final String PAGE_WIDTH = "pageWidth";
	public static final String THEME = "theme";
	public static final String DATE = "date";
	
//	HibernateTemplate hTemplate;

	protected void initDao() {
		//do nothing
	}
	//删除
	
	//修改
	 public void update(Newspaper transientInstance) {
	        log.debug("saving Newspaper instance");
	        try {
	            getHibernateTemplate().update(transientInstance);
	            log.debug("save successful");
	        } catch (RuntimeException re) {
	            log.error("save failed", re);
	            throw re;
	        }
	    }

    //多条件查询
	 public List<Newspaper> getByCondition(Newspaper newspaper){
//		  setHibernateTemplate(hTemplate);
		  
		  log.debug("finding Newspaper instance with property: " + newspaper
		            + ", value: " + newspaper.getName());
		      try {
		    	 
		    	  StringBuilder queryString = new StringBuilder("from Newspaper as model where");
		    	  List<Object> lists = new ArrayList<Object>();
					//if( newspaper.getId() != null && newspaper.getId() != 0 ) {
						queryString.append(" model.id like '%' ");
						//lists.add( newspaper.getId() );
					//}
					if( newspaper.getName() != null && !"".equals( newspaper.getName() ) ) {
						queryString.append(" and model.name = ? ");	
						System.out.println("加入了名字"+newspaper.getName());
						lists.add( newspaper.getName() );
					}
					if( newspaper.getType() != null && !"".equals( newspaper.getType() ) ) {
						queryString.append(" and model.type = ? ");		
						lists.add( newspaper.getType() );
					}
					if( newspaper.getPageNum() != null && newspaper.getPageNum() != 0 ) {
					queryString.append(" and model.pageNum = ? ");
					lists.add( newspaper.getPageNum() );
					}
					if( newspaper.getPageLength() != null && newspaper.getPageLength() != 0 ) {
						queryString.append(" and model.pageLength = ? ");
						lists.add( newspaper.getPageLength() );
						}
					if( newspaper.getPageWidth() != null && newspaper.getPageWidth() != 0 ) {
						queryString.append(" and model.pageWidth = ? ");
						lists.add( newspaper.getPageWidth() );
						}
					if( newspaper.getTheme() != null && !"".equals( newspaper.getTheme() ) ) {
						queryString.append(" and model.theme = ? ");		
						lists.add( newspaper.getTheme() );
					}
					if( newspaper.getDate() != null && !"".equals( newspaper.getDate() ) ) {
						queryString.append(" and model.date = ? ");		
						lists.add( newspaper.getDate() );
					}
					System.out.println(queryString.toString());
					
				 return getHibernateTemplate().find(queryString.toString(),lists.toArray());
				 
		      } catch (RuntimeException re) {
		         log.error("find by property name failed", re);
		         throw re;
		      }
	 }
    public void save(Newspaper transientInstance) {
        log.debug("saving Newspaper instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
   
    
	public void delete(Newspaper persistentInstance) {
        log.debug("deleting Newspaper instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Newspaper findById( java.lang.Integer id) {
        log.debug("getting Newspaper instance with id: " + id);
        try {
            Newspaper instance = (Newspaper) getHibernateTemplate()
                    .get("com.press.pojo.Newspaper", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Newspaper instance) {
        log.debug("finding Newspaper instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    //原生语句查询
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Newspaper instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Newspaper as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
		 
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByPageNum(Object pageNum
	) {
		return findByProperty(PAGE_NUM, pageNum
		);
	}
	
	public List findByPageLength(Object pageLength
	) {
		return findByProperty(PAGE_LENGTH, pageLength
		);
	}
	
	public List findByPageWidth(Object pageWidth
	) {
		return findByProperty(PAGE_WIDTH, pageWidth
		);
	}
	
	public List findByTheme(Object theme
	) {
		return findByProperty(THEME, theme
		);
	}
	

	public List findAll() {
		log.debug("finding all Newspaper instances");
		try {
			String queryString = "from Newspaper";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Newspaper merge(Newspaper detachedInstance) {
        log.debug("merging Newspaper instance");
        try {
            Newspaper result = (Newspaper) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Newspaper instance) {
        log.debug("attaching dirty Newspaper instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Newspaper instance) {
        log.debug("attaching clean Newspaper instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static NewspaperDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (NewspaperDAO) ctx.getBean("NewspaperDAO");
	}
}