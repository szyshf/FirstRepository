package com.birght.comm;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public abstract class HibernateBaseDAO {
	private Session session = null;

	protected Object get(Class clz, Serializable id) {
		Object object = null;
		Session session = getSession();
		try {
			object = session.get(clz, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// closeSession();
		}
		return object;
	}

	protected void add(Object item) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			closeSession();
		}

	}

	protected void update(Object item) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			session.update(item);
			tx.commit();
		} catch (Exception e) {
			if (null != tx) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			closeSession();
		}
	}

	protected void delete(Class clz, Serializable id) {
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			session.delete(get(clz, id));
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			closeSession();
		}
	}

	protected List search(Class clz, Object condition) {
		List result = null;
		try {
			result = getSession().createCriteria(clz).add(
					Example.create(condition)).list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return result;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		this.session = HibernateSessionFactory.getSession();
		return this.session;
	}

	private void closeSession() {
		// TODO Auto-generated method stub
		HibernateSessionFactory.closeSession();
	}

}
