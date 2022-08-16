/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hmh.repository;

import com.hmh.pojo.Nhanvien;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HoanTran
 */
public interface NhanVienRepository {
    List<Nhanvien> getNhanVien(Map<String, String> params, int page);
    int countNhanVien();
    boolean addNhanVien(Nhanvien nv);
    boolean DeleteNhanVien(int id);
    Nhanvien getNhanVienById(int id);   
}
