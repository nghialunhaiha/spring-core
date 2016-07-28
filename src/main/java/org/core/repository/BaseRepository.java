package org.core.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class BaseRepository<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public BaseRepository() {
    }

    public BaseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentActiveSession() {
        try {
            if (sessionFactory.getCurrentSession().isOpen())
                return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            try {
                return sessionFactory.openSession();
            } catch (HibernateException e2) {
            }
        }
        throw new HibernateException("-----------------Session can not be create.-----------------");
    }

    protected List<T> list(Session session, Class<T> clazz) {
        return (List<T>) session.createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    // update
    @Transactional
    protected void update(Session session, Object object) {
        try {
            session.update(object);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    @Transactional
    protected void update(Object object) {
        try {
            getCurrentActiveSession().update(object);
        } catch (Exception e) {
            getCurrentActiveSession().getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    @Transactional
    protected void saveOrUpdate(Session session, Object object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    @Transactional
    // add - isert
    protected void create(Session session, Object object) throws HibernateException {
        try {
            session.save(object);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    @Transactional
    protected void create(Object object) throws HibernateException {
        try {
            getCurrentActiveSession().save(object);
        } catch (Exception e) {
            getCurrentActiveSession().getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    @Transactional
    protected void delete(Session session, Object object) throws HibernateException {
        try {
            session.delete(object);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    protected T findById(String id, Class<T> clazz) {
        return (T) getCurrentActiveSession().get(clazz, id);
    }

    // public void persist(Object entity) {
    // getCurrentActiveSession().persist(entity);
    // }

    // public void delete(Object entity) {
    // getCurrentActiveSession().delete(entity);
    // }
}