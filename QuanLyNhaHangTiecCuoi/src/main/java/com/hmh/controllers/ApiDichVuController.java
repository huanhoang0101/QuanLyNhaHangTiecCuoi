/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Dichvu;
import com.hmh.service.DichVuService;
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
public class ApiDichVuController {
    @Autowired
    private DichVuService dichVuService;
    
    @GetMapping("/dichvu")
    public ResponseEntity<List<Dichvu>> getDichVu() {
        return new ResponseEntity<>(this.dichVuService.getDichVu(null, 0), HttpStatus.OK);
    }
    
    @DeleteMapping("/dichvu/{maDV}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDichVu(@PathVariable(value = "maDV") int id) {
        this.dichVuService.deleteDichVu(id);
    }
}
