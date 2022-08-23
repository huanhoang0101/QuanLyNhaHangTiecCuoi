/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.service.impl;

import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.Menu;
import com.hmh.repository.CommentMonanRepository;
import com.hmh.service.CommentMonanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huan
 */
@Service
public class CommentMonanServiceImpl implements CommentMonanService{
    @Autowired
    private CommentMonanRepository commentMonanRepository;

    @Override
    public List<CommentMonan> getCommentsMonan(int maMenu) {
        return this.commentMonanRepository.getCommentsMonan(maMenu);
    }

    @Override
    public Menu getMenuById(int id) {
        return this.commentMonanRepository.getMenuById(id);
    }

    @Override
    public CommentMonan addCommentMonan(String content, int maMenu) {
        return this.commentMonanRepository.addCommentMonan(content, maMenu);
    }
    
}
