package dao;

// Generated 9 d�c. 2015 14:28:03 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import entity.Produit;
import util.HibernateUtil;

/**
 * Home object for domain model class Produit.
 * @see dao.Produit
 * @author Hibernate Tools
 */
public class ProduitDao {

	private static final Log log = LogFactory.getLog(ProduitDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try { return (SessionFactory) HibernateUtil.sessionFactory;
		} catch (Exception e) {
		log.error("Could not locate SessionFactory ", e);
		throw new IllegalStateException(
		"Could not locate SessionFactory");
		}
		}

	public void persist(Produit transientInstance) {
		log.debug("persisting Produit instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Produit instance) {
		log.debug("attaching dirty Produit instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Produit instance) {
		log.debug("attaching clean Produit instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Produit persistentInstance) {
		log.debug("deleting Produit instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Produit merge(Produit detachedInstance) {
		log.debug("merging Produit instance");
		try {
			Produit result = (Produit) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Produit findById(java.lang.String nomp) {
		log.debug("getting Produit instance with id: " + nomp);
		try {
			openTransaction();
			Produit instance = (Produit) sessionFactory.getCurrentSession().get("entity.Produit", nomp);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	private void openTransaction(){
		sessionFactory.getCurrentSession().beginTransaction();
	}
	
	private void closeTransaction(){
		sessionFactory
		.getCurrentSession().getTransaction().commit();
	}

	

	public List findByExample(Produit instance) {
		log.debug("finding Produit instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dao.Produit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
