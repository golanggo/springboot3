package com.example.test.controller;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import com.example.test.service.WorkerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    final private WorkerService workerService;

    @Autowired
    public LoginController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public Object Login(String mobile, String password) {
        boolean bl = workerService.CheckAccount(mobile, password);
        if (bl) {
            return "login success";
        }
        return "please go to register;";
    }
}


