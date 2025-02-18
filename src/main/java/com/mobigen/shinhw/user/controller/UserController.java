package com.mobigen.shinhw.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobigen.shinhw.user.model.Item;
import com.mobigen.shinhw.user.model.UserInfo;
import com.mobigen.shinhw.user.service.ItermService;
import com.mobigen.shinhw.user.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ItermService itermService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/health")
    public String getMethodName() {
        return new String("OK");
    }

    @GetMapping("/{id}")
    public Item getMethodName(@PathVariable("id") int itemId) {
        System.out.println(String.valueOf(itemId));

        return this.itermService.getItem(itemId);

    }

    @GetMapping("/list")
    public List<UserInfo> getUserList() {
        return this.userService.getUserList();
    }
    
    
    
}
