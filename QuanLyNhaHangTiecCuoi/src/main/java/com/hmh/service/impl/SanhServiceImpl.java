/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmh.pojo.Sanh;
import com.hmh.repository.SanhRepository;
import com.hmh.repository.impl.SanhRepositoryImpl;
import com.hmh.service.SanhService;
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
public class SanhServiceImpl implements SanhService {

    @Autowired
    private SanhRepository sanhRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Sanh> getSanh(Map<String, String> params, int page) {
        return this.sanhRepository.getSanh(params, page);
    }

    @Override
    public int countSanh() {
        return this.sanhRepository.countSanh();
    }

    @Override
    public boolean addSanh(Sanh s) {
        try {
            Map result = this.cloudinary.uploader().upload(s.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) result.get("secure_url");

            s.setImage(img);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }

        return this.sanhRepository.addSanh(s);
    }

    @Override
    public boolean deleteSanh(int id) {
        return this.sanhRepository.deleteSanh(id);
}

    @Override
    public Sanh getSanhById(int id) {
        return this.sanhRepository.getSanhById(id);
    }
}
