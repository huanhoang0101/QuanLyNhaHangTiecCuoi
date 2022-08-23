/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.service;

import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.CommentSanh;
import com.hmh.pojo.Menu;
import com.hmh.pojo.Sanh;
import java.util.List;

/**
 *
 * @author huan
 */
public interface CommentSanhService {
    List<CommentSanh> getCommentsSanh(int maSanh);
    Sanh getSanhById(int id);
    CommentSanh addCommentSanh(String content, int maSanh);
}
