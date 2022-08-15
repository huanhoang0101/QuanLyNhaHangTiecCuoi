/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Sanh;
import com.hmh.service.SanhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HoanTran
 */
@RestController
@RequestMapping("/api")
public class ApiSanhController {
    @Autowired
    private SanhService sanhService;
    
    @GetMapping("/sanh")
    public ResponseEntity<List<Sanh>> getSanh() {
        return new ResponseEntity<>(this.sanhService.getSanh(null, 0), HttpStatus.OK);
    }
    
    @DeleteMapping("/sanh/{maSanh}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSanh(@PathVariable(value = "maSanh") int id) {
        this.sanhService.deleteSanh(id);
    }  
}
