package com.mobigen.shinhw.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobigen.shinhw.user.model.UserInfo;
import com.mobigen.shinhw.user.repository.CustomUserRepository;

@Service
public class UserService {
    

    @Autowired
    private CustomUserRepository userRepository;

    public List<UserInfo> getUserList() {
        return this.userRepository.getUserList();
    }


}
