/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.service.impl;

import com.hmh.pojo.CommentDichvu;
import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.Dichvu;
import com.hmh.pojo.Menu;
import com.hmh.repository.CommentDichvuRepository;
import com.hmh.repository.CommentMonanRepository;
import com.hmh.service.CommentDichvuService;
import com.hmh.service.CommentMonanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huan
 */
@Service
public class CommentDichvuServiceImpl implements CommentDichvuService{
    @Autowired
    private CommentDichvuRepository commentDichvuRepository;

    @Override
    public List<CommentDichvu> getCommentsDichvu(int maDV) {
        return this.commentDichvuRepository.getCommentsDichvu(maDV);
    }

    @Override
    public Dichvu getDichvuById(int id) {
        return this.commentDichvuRepository.getDichvuById(id);
    }

    @Override
    public CommentDichvu addCommentDichvu(String content, int maDV) {
        return this.commentDichvuRepository.addCommentDichvu(content, maDV);
    }
    
}
