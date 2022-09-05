/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hmh.repository;
import com.hmh.pojo.Nhanvien;
/**
 *
 * @author HoanTran
 */
public interface UserRepository {
    Nhanvien getNhanvienTaikhoan(String taikhoan);
}
