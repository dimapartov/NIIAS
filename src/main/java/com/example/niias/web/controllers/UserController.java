package com.example.niias.web.controllers;

import com.example.niias.services.ParameterServiceImpl;
import com.example.niias.web.view.CreateParameterViewModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ParameterServiceImpl parameterServiceImpl;


    @GetMapping("/login")
    public String getLoginPage() {
        return "user-login";
    }

    @GetMapping("/panel")
    public String getUserPanelPage() {
        return "user-panel";
    }


    @ModelAttribute("newParameterModel")
    public CreateParameterViewModel initParameter() {
        return new CreateParameterViewModel();
    }
    @PostMapping("/create-parameter")
    public String createParameter(CreateParameterViewModel newParameterModel) {
        parameterServiceImpl.addParameter(newParameterModel);
        return "redirect:/user/panel";
    }
}