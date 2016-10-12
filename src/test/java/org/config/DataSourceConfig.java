package org.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.led.simba.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment environment;

    /*
     * These session-factory beans are implementations of Spring’s FactoryBean interface that produce a Hibernate
     * SessionFactory when wired into any property of type SessionFactory. This makes it possible to configure your
     * Hibernate session factory alongside the other beans in your application’s Spring context.
     */
    /*
     * LocalSessionFactoryBean is configured here with three properties.
     * 
     * The dataSource property is wired with a reference to a DataSource bean.
     * 
     * The mappingResources property lists one or more Hibernate mapping files that define the persistence strategy for
     * the application.
     * 
     * Finally, hibernateProperties is where you configure the minutia of how Hibernate should operate.
     * 
     * In this case, you’re saying that Hibernate will be working with an H2 database and should use the H2Dialect to
     * construct SQL accordingly.
     */
    @Bean
    // LocalSessionFactoryBean is configured here with three properties
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"org.led.simba"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    /*
     * sessionFactory also can be configure by AOP way: using AnnotationSesstionFactoryBean
     * 
     */
    // @Bean
    // public AnnotationSessionFactoryBean sessionFactory2() {
    // AnnotationSessionFactoryBean sfb = new AnnotationSessionFactoryBean();
    // sfb.setDataSource(dataSource());
    // sfb.setPackagesToScan(new String[] { "com.habuma.spittr.domain" });
    // Properties props = new Properties();
    // props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
    // sfb.setHibernateProperties(props);
    // return sfb;
    // }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    @Profile("product")
    public DataSource dataSourceProduct() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    /*
     * PersistenceExceptionTranslationPostProcessor is a bean post-processor that adds an adviser to any bean that’s
     * annotated with @Repository so that any platform-specific exceptions are caught and then rethrown as one of
     * Spring’s unchecked data-access exceptions.
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
