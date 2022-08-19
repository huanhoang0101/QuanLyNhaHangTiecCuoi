/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Nhanvien;
import com.hmh.service.NhanVienService;
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
public class ApiNhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhanvien")
    public ResponseEntity<List<Nhanvien>> getNhanVien() {
        return new ResponseEntity<>(this.nhanVienService.getNhanVien(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/nhanvien/{maNV}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNhanVien(@PathVariable(value = "maNV") int id) {
        this.nhanVienService.DeleteNhanVien(id);
    }
}
