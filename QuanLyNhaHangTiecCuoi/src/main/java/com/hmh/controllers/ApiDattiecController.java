/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.controllers;

import com.hmh.pojo.DatDichvu;
import com.hmh.pojo.DatMonan;
import com.hmh.pojo.DatSanh;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author huan
 */
@RestController
public class ApiDattiecController {
    @PostMapping("/api/dattiecmonan")
    public void addToDatMonan(@RequestBody DatMonan paramsmonan, HttpSession session){
        Map<Integer, DatMonan> datMonan = (Map<Integer, DatMonan>) session.getAttribute("datmon");
        if(datMonan == null)
            datMonan = new HashMap<>();
        
        int maMenu = paramsmonan.getMaMenu();
        if(datMonan.containsKey(maMenu) == true){
            DatMonan d = datMonan.get(maMenu);
            d.setSoLuong(d.getSoLuong() + 1);
        }else{
            datMonan.put(maMenu, paramsmonan);
        }
        
        session.setAttribute("datmon", datMonan);                           
    }
    
    @PostMapping("/api/dattiecdichvu")
    public void addToDatDichvu(@RequestBody DatDichvu paramsdichvu, HttpSession session){
        Map<Integer, DatDichvu> datDichvu = (Map<Integer, DatDichvu>) session.getAttribute("datdichvu");
        if(datDichvu == null)
            datDichvu = new HashMap<>();
        
        int maDV = paramsdichvu.getMaDV();        
            datDichvu.put(maDV, paramsdichvu);
        
        session.setAttribute("datdichvu", datDichvu);
    }
    
    @PostMapping("/api/dattiecsanh")
    public void addToDatSanh(@RequestBody DatSanh paramssanh, HttpSession session){
        Map<Integer, DatSanh> datSanh = (Map<Integer, DatSanh>) session.getAttribute("datsanh");
        if(datSanh == null)
            datSanh = new HashMap<>();
        
        int maSanh = paramssanh.getMaSanh();        
            datSanh.put(maSanh, paramssanh);
        
        session.setAttribute("datsanh", datSanh);
    }
    
    @PutMapping("/api/dattiecmonan")
    @ResponseStatus(HttpStatus.OK)
    public void updateDatMonan(@RequestBody DatMonan paramsmonan, HttpSession session){
        Map<Integer, DatMonan> datMonan = (Map<Integer, DatMonan>) session.getAttribute("datmon");
        if(datMonan == null)
            datMonan = new HashMap<>();
        
        int maMenu = paramsmonan.getMaMenu();
        if(datMonan.containsKey(maMenu) == true){
            DatMonan d = datMonan.get(maMenu);
            d.setSoLuong(paramsmonan.getSoLuong());
        }
        
        session.setAttribute("datmon", datMonan);          
    }
    
    @DeleteMapping("/api/dattiecmonan/{maMenu}")
    public void deleteDatMonan(@PathVariable(value = "maMenu") int maMenu, 
            HttpSession session){
        Map<Integer, DatMonan> datMonan = (Map<Integer, DatMonan>) session.getAttribute("datmon");
        if(datMonan != null && datMonan.containsKey(maMenu)){
            datMonan.remove(maMenu);
            
            session.setAttribute("datmon", datMonan);   
        }          
    }
    
    @DeleteMapping("/api/dattiecsanh/{maSanh}")
    public void deleteDatSanh(@PathVariable(value = "maSanh") int maSanh, 
            HttpSession session){
        Map<Integer, DatSanh> datSanh = (Map<Integer, DatSanh>) session.getAttribute("datsanh");
        if(datSanh != null && datSanh.containsKey(maSanh)){
            datSanh.remove(maSanh);
            
            session.setAttribute("datsanh", datSanh);   
        }          
    }
    
    @DeleteMapping("/api/dattiecdichvu/{maDV}")
    public void deleteDatDichvu(@PathVariable(value = "maDV") int maDV, 
            HttpSession session){
        Map<Integer, DatDichvu> datDichvu = (Map<Integer, DatDichvu>) session.getAttribute("datdichvu");
        if(datDichvu != null && datDichvu.containsKey(maDV)){
            datDichvu.remove(maDV);
            
            session.setAttribute("datdichvu", datDichvu);   
        }          
    }
}
