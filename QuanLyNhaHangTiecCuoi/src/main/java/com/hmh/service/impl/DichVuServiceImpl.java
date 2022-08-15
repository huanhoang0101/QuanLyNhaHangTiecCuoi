/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmh.pojo.Dichvu;
import com.hmh.repository.DichVuRepository;
import com.hmh.service.DichVuService;
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
public class DichVuServiceImpl implements  DichVuService{
    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Dichvu> getDichVu(Map<String, String> params, int page) {
        return this.dichVuRepository.getDichVu(params, page);
    }
    
    @Override
    public int countDichVu() {
        return this.dichVuRepository.countDichVu();
    }

    @Override
    public boolean addDichVu(Dichvu dv) {
        try {
            Map result = this.cloudinary.uploader().upload(dv.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");
            
            dv.setImage(img);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    
        return this.dichVuRepository.addDichVu(dv);
    }

    @Override
    public boolean deleteDichVu(int id) {
        return this.dichVuRepository.deleteDichVu(id);
    }

    @Override
    public Dichvu getDichVuById(int id) {
        return this.dichVuRepository.getDichVuById(id);
    }
}