/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmh.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmh.pojo.Menu;
import com.hmh.service.MonAnService;
import com.hmh.service.SanhService;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author huan
 */
@Controller
@RequestMapping("/admin")
public class MonAnController {

    @Autowired
    private MonAnService monAnService;

    @GetMapping("/menu")
    public String list(Model model) {
        model.addAttribute("menu", new Menu());

        return "menu";
    }

    @PostMapping("/menu")
    public String add(@ModelAttribute(value = "menu") @Valid Menu m,
            BindingResult r) {

        if (r.hasErrors()) {
            return "menu";
        }

        if (this.monAnService.addMonAn(m) == true) {
            return "redirect:/";
        }

        return "menu";
    }

    @GetMapping("/monan/{maMenu}")
    public String detail(Model model, @PathVariable(value = "maMenu") int maMenu) {
        model.addAttribute("menu", this.monAnService.getMenuById(maMenu));

        return "monan-detail";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("catStats", this.monAnService.countMonAnByCate());
        return "stats";
    }
}
