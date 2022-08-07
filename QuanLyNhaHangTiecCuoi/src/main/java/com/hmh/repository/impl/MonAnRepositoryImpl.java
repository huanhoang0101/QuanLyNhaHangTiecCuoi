/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.Menu;
import com.hmh.repository.MonAnRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HoanTran
 */
@Repository
@Transactional
public class MonAnRepositoryImpl implements MonAnRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Menu> getMonAn() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Menu");
        return q.getResultList();
    }
    
}
