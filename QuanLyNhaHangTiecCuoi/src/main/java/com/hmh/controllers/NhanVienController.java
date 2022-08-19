/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Nhanvien;
import com.hmh.service.NhanVienService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HoanTran
 */
@Controller
@RequestMapping("/admin")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhanvien")
    public String list(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());

        return "nhanvien";
    }

    @PostMapping("/nhanvien")
    public String add(@ModelAttribute(value = "nhanvien") @Valid Nhanvien nv,
            BindingResult r) {

        if (r.hasErrors()) {
            return "nhanvien";
        }

        if (this.nhanVienService.addNhanVien(nv) == true)
            return "redirect:/";

        return "nhanvien";
    }   
} 
