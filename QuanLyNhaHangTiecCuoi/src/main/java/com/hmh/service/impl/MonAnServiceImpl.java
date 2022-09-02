/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmh.pojo.Menu;
import com.hmh.repository.MonAnRepository;
import com.hmh.service.MonAnService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HoanTran
 */
@Service
public class MonAnServiceImpl implements MonAnService{
    @Autowired
    private MonAnRepository monAnRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Menu> getMonAn(Map<String, String> params, int page) {
        return this.monAnRepository.getMonAn(params, page);
    }
    
    @Override
    public int countMonAn() {
        return this.monAnRepository.countMonAn();
    }

    @Override
    public boolean addMonAn(Menu m) {
        try {
            Map result = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");
            
            m.setImage(img);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    
        return this.monAnRepository.addMonAn(m);
    }

    @Override
    public boolean deleteMonAn(int id) {
        return this.monAnRepository.deleteMonAn(id);
    }

    @Override
    public Menu getMenuById(int id) {
        return this.monAnRepository.getMenuById(id);
    }

    @Override
    public List<Object[]> countMonAnByCate() {
        return this.monAnRepository.countMonAnByCate();
}
}
