/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Sanh;
import com.hmh.service.SanhService;
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
public class SanhController {
    @Autowired
    private SanhService sanhService;   
    
    @GetMapping("/sanh")
    public String list(Model model) {
        model.addAttribute("sanh", new Sanh());
        
        return "sanh";
    }
    
    @PostMapping("/sanh")
    public String add(@ModelAttribute(value = "sanh") @Valid Sanh s,
            BindingResult r) {
               
        if (r.hasErrors()) {
            return "sanh";
        }
        
        if (this.sanhService.addSanh(s) == true)
            return "redirect:/";
        
        return "sanh";
    }
    
    @GetMapping("/sanh/{maSanh}")
    public String detail(Model model, @PathVariable(value = "maSanh") int maSanh) {       
        model.addAttribute("sanh", this.sanhService.getSanhById(maSanh));
        
        return "sanh-detail";
    }
    
}