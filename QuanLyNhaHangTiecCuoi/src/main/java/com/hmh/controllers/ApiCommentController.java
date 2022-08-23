/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.controllers;

import com.hmh.pojo.CommentDichvu;
import com.hmh.pojo.CommentMonan;
import com.hmh.pojo.CommentSanh;
import com.hmh.service.CommentDichvuService;
import com.hmh.service.CommentMonanService;
import com.hmh.service.CommentSanhService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author huan
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private CommentMonanService commentMonanService;
    @Autowired
    private CommentSanhService commentSanhService;
    @Autowired
    private CommentDichvuService commentDichvuService;
    
    //Comment Menu
    @GetMapping("/menu/{maMenu}/comments")
    public ResponseEntity<List<CommentMonan>> getCommentsMonan(@PathVariable(value = "maMenu") int id) {
        
        return new ResponseEntity<>(this.commentMonanService.getCommentsMonan(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/menu/{maMenu}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<CommentMonan> addCommentMonan(@RequestBody Map<String, String> params) {
        String content = params.get("content");
        int maMenu = Integer.parseInt(params.get("maMenu"));
        
        CommentMonan c = this.commentMonanService.addCommentMonan(content, maMenu);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    //Comment Sanh
    @GetMapping("/sanh/{maSanh}/comments")
    public ResponseEntity<List<CommentSanh>> getCommentsSanh(@PathVariable(value = "maSanh") int id) {
        
        return new ResponseEntity<>(this.commentSanhService.getCommentsSanh(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/sanh/{maSanh}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<CommentSanh> addCommentSanh(@RequestBody Map<String, String> params) {
        String content = params.get("content");
        int maSanh = Integer.parseInt(params.get("maSanh"));
        
        CommentSanh c = this.commentSanhService.addCommentSanh(content, maSanh);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    //Comment Dich vu
    @GetMapping("/dichvu/{maDV}/comments")
    public ResponseEntity<List<CommentDichvu>> getCommentsDicvu(@PathVariable(value = "maDV") int id) {
        
        return new ResponseEntity<>(this.commentDichvuService.getCommentsDichvu(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/dichvu/{maDV}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<CommentDichvu> addCommentDichvu(@RequestBody Map<String, String> params) {
        String content = params.get("content");
        int maDV = Integer.parseInt(params.get("maDV"));
        
        CommentDichvu c = this.commentDichvuService.addCommentDichvu(content, maDV);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
