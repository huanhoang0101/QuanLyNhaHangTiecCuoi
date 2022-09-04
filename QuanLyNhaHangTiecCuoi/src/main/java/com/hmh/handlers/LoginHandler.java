/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.handlers;

import com.hmh.pojo.Nhanvien;
import com.hmh.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author HoanTran
 */
@Component
public class LoginHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        Nhanvien nv = this.userService.getNhanvienTaikhoan(a.getName());
        request.getSession().setAttribute("currentUser", nv);

        response.sendRedirect("/QuanLyNhaHangTiecCuoi/");
    }

}
