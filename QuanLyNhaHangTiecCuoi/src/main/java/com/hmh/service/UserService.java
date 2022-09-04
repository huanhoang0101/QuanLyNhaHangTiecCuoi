/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service;

import com.hmh.pojo.Nhanvien;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HoanTran
 */
public interface UserService extends UserDetailsService{
    Nhanvien getNhanvienTaikhoan(String taikhoan);
}
