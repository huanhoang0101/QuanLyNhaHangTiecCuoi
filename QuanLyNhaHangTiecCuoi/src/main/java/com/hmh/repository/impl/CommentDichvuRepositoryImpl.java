/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.repository.impl;

import com.hmh.pojo.CommentDichvu;
import com.hmh.pojo.Dichvu;
import com.hmh.pojo.Khachhang;
import com.hmh.repository.CommentDichvuRepository;
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
public class CommentDichvuRepositoryImpl implements CommentDichvuRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<CommentDichvu> getCommentsDichvu(int maDV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CommentDichvu> q = b.createQuery(CommentDichvu.class);
        Root root = q.from(CommentDichvu.class);
        q.select(root);

        q.where(b.equal(root.get("dichvuId"), maDV));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Dichvu getDichvuById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Dichvu.class, id);
    }

    @Override
    public CommentDichvu addCommentDichvu(String content, int maDV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CommentDichvu c = new CommentDichvu();
        c.setContent(content);
        c.setDichvuId(this.getDichvuById(maDV));
        c.setUserId(session.get(Khachhang.class, 1));
        
        session.save(c);
        
        return c;
    }

}
