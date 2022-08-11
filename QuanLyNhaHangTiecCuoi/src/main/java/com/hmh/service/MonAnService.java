/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hmh.service;

import com.hmh.pojo.Menu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HoanTran
 */
public interface MonAnService {
    List<Menu> getMonAn(Map<String, String> params, int page);
    int countMonAn();
}
