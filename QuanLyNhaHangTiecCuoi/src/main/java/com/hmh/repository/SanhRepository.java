/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hmh.repository;

import com.hmh.pojo.Sanh;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HoanTran
 */
public interface SanhRepository {
    List<Sanh> getSanh(Map<String, String> params, int page);
    int countSanh();
    boolean addSanh(Sanh s);
    boolean deleteSanh(int id);
    Sanh getSanhById(int id);
}