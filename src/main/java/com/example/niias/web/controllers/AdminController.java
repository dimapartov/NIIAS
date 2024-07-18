package com.example.niias.web.controllers;

import com.example.niias.models.Parameter;
import com.example.niias.services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ParameterService parameterService;


    @GetMapping("/parameters")
    public String getParametersPage(Model model) {
        model.addAttribute("parameters", parameterService.getAllParameters());
        return "admin-panel";
    }

    @PostMapping("/parameters/add")
    public String addParameter(@ModelAttribute Parameter parameter) {
        parameterService.saveParameter(parameter);
        return "redirect:/admin/parameters";
    }

    @PostMapping("/parameters/delete")
    public String deleteParameter(@RequestParam Long id) {
        parameterService.deleteParameter(id);
        return "redirect:/admin/parameters";
    }

}