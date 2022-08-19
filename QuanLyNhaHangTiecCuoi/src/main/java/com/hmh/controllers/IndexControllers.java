/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.service.DichVuService;
import com.hmh.service.MonAnService;
import com.hmh.service.NhanVienService;
import com.hmh.service.SanhService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.management.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HoanTran
 */
@Controller
@ControllerAdvice
public class IndexControllers {
    @Autowired
    private MonAnService monAnService;
    @Autowired
    private LocalSessionFactoryBean SessionFactory;
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private SanhService sanhService;
    @Autowired
    private NhanVienService nhanVienService;
    
    
    @ModelAttribute
    public void commonAttr(Model model) {
        List<String> categories = new ArrayList<>();
        categories.add("Sảnh");
        categories.add("Menu");
        categories.add("Dịch vụ");
        model.addAttribute("categories", categories);
    } 
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("menus", this.monAnService.getMonAn(params, page));
        model.addAttribute("MonAnCounter", this.monAnService.countMonAn());
        
        return "index";
        
    }
    
    @RequestMapping("/dichvuIndex")
    @Transactional
    public String dichvuIndex(Model model, @RequestParam Map<String, String> params) {    
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("dichvus", this.dichVuService.getDichVu(params, page));
        model.addAttribute("DichVuCounter", this.dichVuService.countDichVu());
        
        return "dichvuIndex";  
    }
    
    @RequestMapping("/sanhIndex")
    @Transactional
    public String sanhIndex(Model model, @RequestParam Map<String, String> params) {    
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("sanhs", this.sanhService.getSanh(params, page));
        model.addAttribute("SanhCounter", this.sanhService.countSanh());
        return "sanhIndex";  
    }
}
