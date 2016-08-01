package org.core.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    protected T update(Session session, T object) {
        try {
            session.update(object);
            return object;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    protected T update(T object) {
        try {
            sessionFactory.getCurrentSession().update(object);
            return object;
        } catch (Exception e) {
            throw new HibernateException(e);
        }
    }

    protected T saveOrUpdate(Session session, T object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
            return object;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    // add - isert
    protected T create(Session session, T object) throws HibernateException {
        try {
            session.save(object);
            return object;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    protected T create(T object) throws HibernateException {
        try {
            getCurrentActiveSession().save(object);
            return object;
        } catch (Exception e) {
            getCurrentActiveSession().getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    protected void delete(Object object) throws HibernateException {
        try {
            getCurrentActiveSession().delete(object);
        } catch (Exception e) {
            getCurrentActiveSession().getTransaction().rollback();
            throw new HibernateException(e);
        }
    }

    protected T findById(Long id, Class<T> clazz) {
        return (T) getCurrentActiveSession().get(clazz, id);
    }

    // public void persist(Object entity) {
    // getCurrentActiveSession().persist(entity);
    // }

    // public void delete(Object entity) {
    // getCurrentActiveSession().delete(entity);
    // }
}