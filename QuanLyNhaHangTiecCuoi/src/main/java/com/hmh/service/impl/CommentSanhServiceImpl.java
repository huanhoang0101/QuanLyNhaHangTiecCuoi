/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.service.impl;

import com.hmh.pojo.CommentSanh;
import com.hmh.pojo.Sanh;
import com.hmh.repository.CommentSanhRepository;
import com.hmh.service.CommentSanhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huan
 */
@Service
public class CommentSanhServiceImpl implements CommentSanhService{
    @Autowired
    private CommentSanhRepository commentSanhRepository;

    @Override
    public List<CommentSanh> getCommentsSanh(int maSanh) {
        return this.commentSanhRepository.getCommentsSanh(maSanh);
    }

    @Override
    public Sanh getSanhById(int id) {
        return this.commentSanhRepository.getSanhById(id);
    }

    @Override
    public CommentSanh addCommentSanh(String content, int maSanh) {
        return this.commentSanhRepository.addCommentSanh(content, maSanh);
    }
    
}
