/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.service.MonAnService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.management.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HoanTran
 */
@Controller
public class IndexControllers {
    @Autowired
    private MonAnService monAnService;
    @Autowired
    private LocalSessionFactoryBean SessionFactory;
    
     @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("menus", this.monAnService.getMonAn());
    }
    @RequestMapping("/")
    @Transactional
    public String index(Model model,
        @RequestParam(value = "kw", defaultValue = "") String kw){
        List<String> category = new ArrayList<>();
        category.add("Menu");
        category.add("Ca");
        category.add("Sanh");
        
//        model.addAttribute("Mon An", this.MonAnService.getMonAn());
        model.addAttribute("category", category);
        
//        List<String> product = new ArrayList<>();
////        product.add("Gỏi tôm thái tây thi");
////        product.add("Chả giò chiên giòn");
////        product.add("Mực viên bao trứng muối");
////        product.add("Tôm giòn leo chanh");
////        product.add("Chả thanh cua Nhật");
////        product.add("Cơm chiên gà quay lá é");
////        product.add("Cơm chiên gà quay lá é");
//        
//        if(kw !=null && !kw.isEmpty()){
//              model.addAttribute("menu", product.stream().
//                     filter(m -> m.contains(kw)).collect(Collectors.toList()));
//        }
//        else
//        model.addAttribute("product", product);
        
       
        return "index";
        
    }
}
