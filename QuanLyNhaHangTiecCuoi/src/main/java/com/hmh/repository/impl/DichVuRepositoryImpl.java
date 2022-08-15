/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.Dichvu;
import com.hmh.repository.DichVuRepository;
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
public class DichVuRepositoryImpl implements DichVuRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Dichvu> getDichVu(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Dichvu> q = b.createQuery(Dichvu.class);
        Root root = q.from(Dichvu.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("tenDV").as(String.class), String.format("%%%s%%", kw));
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
    public int countDichVu() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Dichvu");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addDichVu(Dichvu dv) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(dv);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDichVu(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Dichvu dv = session.get(Dichvu.class, id);
            session.delete(dv);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public Dichvu getDichVuById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Dichvu.class, id);
    }
}
