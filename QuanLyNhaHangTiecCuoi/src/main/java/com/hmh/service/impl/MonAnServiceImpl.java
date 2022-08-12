/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.Menu;
import com.hmh.repository.MonAnRepository;
import com.hmh.service.MonAnService;
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
        m.setImage("https://res.cloudinary.com/dnrpggpn0/image/upload/v1659920425/Foods/com_tam_w9raak.png");
    
        return this.monAnRepository.addMonAn(m);
    }

    @Override
    public boolean deleteMonAn(int id) {
        return this.monAnRepository.deleteMonAn(id);
    }
}
