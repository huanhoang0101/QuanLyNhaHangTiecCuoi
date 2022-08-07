/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.Menu;
import com.hmh.repository.MonAnRepository;
import com.hmh.service.MonAnService;
import java.util.List;
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
    public List<Menu> getMonAn() {
        return this.monAnRepository.getMonAn();
    }
    
}
