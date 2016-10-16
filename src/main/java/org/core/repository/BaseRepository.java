package org.core.repository;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class BaseRepository<T> {
    Logger logger = Logger.getLogger(BaseRepository.class);

    private static final String AND = "AND";
    private static final String EQUAL = " = ";
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
        try {
            return (List<T>) session.createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        } catch (HibernateException e) {
            logger.error("Can not connect to MySQL.", e.getCause());
            return Collections.emptyList();
        }
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
            throw new HibernateException(e.getMessage(), e);
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

    protected List<T> findByParams(String tableName, Class<T> clazz, LinkedHashMap<String, Object> paramByKey) {
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName);
        sql.append(" where");
        for(Map.Entry<String, Object> entry : paramByKey.entrySet()) {
            sql.append(" ");
            sql.append(tableName);
            sql.append(".");
            sql.append(entry.getKey());
            sql.append(EQUAL);
            sql.append("\"" +entry.getValue() + "\" ");
            sql.append(AND);
        }
        sql.delete(sql.length() - AND.length(), sql.length());
        SQLQuery sqlquery = getCurrentActiveSession().createSQLQuery(sql.toString());

        sqlquery.addEntity(clazz);
        return sqlquery.list();
    }
}