/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.controllers;

import com.hmh.pojo.DatDichvu;
import com.hmh.pojo.DatMonan;
import com.hmh.pojo.DatSanh;
import com.hmh.service.DichVuService;
import com.hmh.service.MonAnService;
import com.hmh.service.SanhService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author huan
 */
@Controller
public class DattiecController {   
    @Autowired
    private SanhService sanhService;
    @Autowired
    private MonAnService monAnService;
    @Autowired
    private DichVuService dichVuService;
    
    @RequestMapping("/dat-sanh")
    @Transactional
    public String datSanh(Model model, @RequestParam Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("sanhs", this.sanhService.getSanh(params, page));
        model.addAttribute("SanhCounter", this.sanhService.countSanh());
        
        return "dat-sanh";  
    }
    
    @RequestMapping("/dat-menu")
    @Transactional
    public String datMenu(Model model, @RequestParam Map<String, String> params) { 
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("menus", this.monAnService.getMonAn(params, page));
        model.addAttribute("MonAnCounter", this.monAnService.countMonAn());
        
        return "dat-menu";  
    }
    
    @RequestMapping("/dat-dichvu")
    @Transactional
    public String datDichvu(Model model, @RequestParam Map<String, String> params) { 
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("dichvus", this.dichVuService.getDichVu(params, page));
        model.addAttribute("DichVuCounter", this.dichVuService.countDichVu());
        
        return "dat-dichvu";  
    }
    
    @GetMapping("/dattiec")
    public String dattiec(Model model, HttpSession session) {
        //Dat menu
        Map<Integer, DatMonan> datMonan = (Map<Integer, DatMonan>) session.getAttribute("datmon");
        if (datMonan != null)
            model.addAttribute("datmonan", datMonan.values());
        
        //Dat dichvu
        Map<Integer, DatDichvu> datDichvu = (Map<Integer, DatDichvu>) session.getAttribute("datdichvu");
        if (datDichvu != null)
            model.addAttribute("datDV", datDichvu.values());
        
        //Dat Sanh
        Map<Integer, DatSanh> datSanh = (Map<Integer, DatSanh>) session.getAttribute("datsanh");
            model.addAttribute("datsanhcuoi", datSanh.values());
        
        
        return "dattiec";
    }
}
