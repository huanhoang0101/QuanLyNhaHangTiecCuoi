/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository;

import com.hmh.pojo.Menu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HoanTran
 */
public interface MonAnRepository {
    List<Menu> getMonAn(Map<String, String> params, int page);
    int countMonAn();
    boolean addMonAn(Menu m);
    boolean deleteMonAn(int id);
    Menu getMenuById(int id);
}
