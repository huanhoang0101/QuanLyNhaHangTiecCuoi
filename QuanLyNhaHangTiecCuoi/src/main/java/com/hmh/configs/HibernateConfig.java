/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author huan
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean f = new LocalSessionFactoryBean();
        f.setPackagesToScan(new String[]{
            "com.hmh.pojo"
        });
        f.setDataSource(dataSource());
        f.setHibernateProperties(hibernateProperties());
        return f;
    }
        @Bean
        public DataSource dataSource() {
        DriverManagerDataSource dataSource
                    = new DriverManagerDataSource();
            dataSource.setDriverClassName(
                    env.getProperty("hibernate.connection.driverClass"));
            dataSource.setUrl(env.getProperty("hibernate.connection.url"));
            dataSource.setUsername(
                    env.getProperty("hibernate.connection.username"));
            dataSource.setPassword(
                    env.getProperty("hibernate.connection.password"));
            return dataSource;
        }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
        props.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.showSql"));
        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager t
                = new HibernateTransactionManager();
        t.setSessionFactory(sessionFactory().getObject());
        return t;
    }
}
