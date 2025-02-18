package com.mobigen.shinhw.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobigen.shinhw.user.model.Item;
import com.mobigen.shinhw.user.repository.ItemRepository;

@Service
public class ItermService {
    
    @Autowired
    private ItemRepository itemRepository;

    public Item getItem(int id) {
        return this.itemRepository.getItem(id);
    }
}
