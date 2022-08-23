/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.service;

import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.Menu;
import java.util.List;

/**
 *
 * @author huan
 */
public interface CommentMonanService {
    List<CommentMonan> getCommentsMonan(int maMenu);
    Menu getMenuById(int id);
    CommentMonan addCommentMonan(String content, int maMenu);
}
