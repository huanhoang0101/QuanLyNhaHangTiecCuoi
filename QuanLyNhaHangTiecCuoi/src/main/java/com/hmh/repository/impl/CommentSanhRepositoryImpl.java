/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.repository.impl;

import com.hmh.pojo.CommentSanh;
import com.hmh.pojo.Khachhang;
import com.hmh.pojo.Sanh;
import com.hmh.repository.CommentSanhRepository;
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
public class CommentSanhRepositoryImpl implements CommentSanhRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<CommentSanh> getCommentsSanh(int maSanh) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CommentSanh> q = b.createQuery(CommentSanh.class);
        Root root = q.from(CommentSanh.class);
        q.select(root);

        q.where(b.equal(root.get("sanhId"), maSanh));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Sanh getSanhById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Sanh.class, id);
    }

    @Override
    public CommentSanh addCommentSanh(String content, int maSanh) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CommentSanh c = new CommentSanh();
        c.setContent(content);
        c.setSanhId(this.getSanhById(maSanh));
        c.setUserId(session.get(Khachhang.class, 1));
        
        session.save(c);
        
        return c;
    }

}
