/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.Nhanvien;
import com.hmh.repository.NhanVienRepository;
import com.hmh.service.NhanVienService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HoanTran
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<Nhanvien> getNhanVien(Map<String, String> params, int page) {
        return this.nhanVienRepository.getNhanVien(params, page);
    }

    @Override
    public int countNhanVien() {
        return this.nhanVienRepository.countNhanVien();
}

    @Override
    public boolean addNhanVien(Nhanvien nv) {
        return this.nhanVienRepository.addNhanVien(nv);
}

    @Override
    public boolean DeleteNhanVien(int id) {
        return this.nhanVienRepository.DeleteNhanVien(id);
}

    @Override
    public Nhanvien getNhanVienById(int id) {
        return this.nhanVienRepository.getNhanVienById(id);
    }
}
