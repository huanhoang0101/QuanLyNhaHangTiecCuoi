/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hmh.service;

import com.hmh.pojo.Dichvu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HoanTran
 */
public interface DichVuService {
    List<Dichvu> getDichVu(Map<String, String> params, int page);
    int countDichVu();
    boolean addDichVu(Dichvu dv);
    boolean deleteDichVu(int id);
    Dichvu getDichVuById(int id);
}
