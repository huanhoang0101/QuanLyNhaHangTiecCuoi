/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.repository;

import com.hmh.pojo.CommentDichvu;
import com.hmh.pojo.Dichvu;
import java.util.List;

/**
 *
 * @author huan
 */
public interface CommentDichvuRepository {
    List<CommentDichvu> getCommentsDichvu(int maDV);
    Dichvu getDichvuById(int id);
    CommentDichvu addCommentDichvu(String content, int maDV);
}
