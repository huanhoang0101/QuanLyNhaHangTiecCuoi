/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.Dichvu;
import com.hmh.service.DichVuService;
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
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;   
    
    @GetMapping("/dichvu")
    public String list(Model model) {
        model.addAttribute("dichvu", new Dichvu());
        
        return "dichvu";
    }
    
    @PostMapping("/dichvu")
    public String add(@ModelAttribute(value = "dichvu") @Valid Dichvu dv,
            BindingResult r) {
               
        if (r.hasErrors()) {
            return "dichvu";
        }
        
        if (this.dichVuService.addDichVu(dv) == true)
            return "redirect:/";
        
        return "dichvu";
    }
    
    @GetMapping("/dichvu/{maDV}")
    public String detail(Model model, @PathVariable(value = "maDV") int maDV) {       
        model.addAttribute("dichvu", this.dichVuService.getDichVuById(maDV));
        
        return "dichvu-detail";
    }
    
}
