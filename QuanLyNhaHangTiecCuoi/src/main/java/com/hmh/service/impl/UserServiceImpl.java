/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.Nhanvien;
import com.hmh.repository.UserRepository;
import com.hmh.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author HoanTran
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Nhanvien getNhanvienTaikhoan(String taikhoan) {
        return this.userRepository.getNhanvienTaikhoan(taikhoan);
    }

    @Override
    public UserDetails loadUserByUsername(String taikhoan) throws UsernameNotFoundException {
        Nhanvien nv = this.getNhanvienTaikhoan(taikhoan);
        if (nv == null) {
            throw new UsernameNotFoundException("Invalid username!!!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(nv.getLoaiNV()));

        return new org.springframework.security.core.userdetails.User(
                nv.getTaiKhoan(), nv.getMatKhau(), authorities);
    }
}
