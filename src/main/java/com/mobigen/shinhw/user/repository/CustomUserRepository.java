package com.mobigen.shinhw.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobigen.shinhw.user.model.UserInfo;

@Repository
public interface CustomUserRepository {
    List<UserInfo> getUserList();
}
