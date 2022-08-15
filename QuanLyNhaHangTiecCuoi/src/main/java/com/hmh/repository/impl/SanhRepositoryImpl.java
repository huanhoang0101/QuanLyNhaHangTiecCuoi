/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.Sanh;
import com.hmh.repository.SanhRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class SanhRepositoryImpl implements SanhRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Sanh> getSanh(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> q = b.createQuery(Sanh.class);
            Root root = q.from(Sanh.class);
            q.select(root);
            
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p = b.like(root.get("ten").as(String.class), String.format("%%%s%%", kw));
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
    public int countSanh() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Sanh");
        return Integer.parseInt(q.getSingleResult().toString());
}

    @Override
    public boolean addSanh(Sanh s) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(s);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSanh(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Sanh s = session.get(Sanh.class, id);
            session.delete(s);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Sanh getSanhById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Sanh.class, id);
    }   
}
