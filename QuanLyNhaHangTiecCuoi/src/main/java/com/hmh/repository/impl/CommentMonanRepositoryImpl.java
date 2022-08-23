/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.repository.impl;

import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.Khachhang;
import com.hmh.pojo.Menu;
import com.hmh.repository.CommentMonanRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huan
 */
@Repository
@Transactional
public class CommentMonanRepositoryImpl implements CommentMonanRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<CommentMonan> getCommentsMonan(int maMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CommentMonan> q = b.createQuery(CommentMonan.class);
        Root root = q.from(CommentMonan.class);
        q.select(root);

        q.where(b.equal(root.get("monanId"), maMenu));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Menu getMenuById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Menu.class, id);
    }

    @Override
    public CommentMonan addCommentMonan(String content, int maMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CommentMonan c = new CommentMonan();
        c.setContent(content);
        c.setMonanId(this.getMenuById(maMenu));
        c.setUserId(session.get(Khachhang.class, 1));
        
        session.save(c);
        
        return c;
    }

}
