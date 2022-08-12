/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.Menu;
import com.hmh.repository.MonAnRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HoanTran
 */
@Repository
@Transactional
@PropertySource("classpath:databases.properties")
public class MonAnRepositoryImpl implements MonAnRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Menu> getMonAn(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menu> q = b.createQuery(Menu.class);
            Root root = q.from(Menu.class);
            q.select(root);
            
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p = b.like(root.get("tenMon").as(String.class), String.format("%%%s%%", kw));
                    predicates.add(p);
                }
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            org.hibernate.query.Query query = session.createQuery(q);
            if (page > 0) {
                int size = Integer.parseInt(env.getProperty("page.size").toString());
                int start = (page - 1) * size;
                query.setFirstResult(start);
                query.setMaxResults(size);
                
            }
            
            return query.getResultList();
    }
    
    @Override
    public int countMonAn() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Menu");
        
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addMonAn(Menu m) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteMonAn(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            Menu m = session.get(Menu.class, id);
            session.delete(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
