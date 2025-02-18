package com.mobigen.shinhw.user.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Repository;

import com.mobigen.shinhw.user.model.Item;

import jakarta.annotation.PostConstruct;

@Component
public class ItemRepository {
    
    private Map<Integer, Item> fakeDb;

    @PostConstruct
    public void init() {
        if (fakeDb == null || 1 > fakeDb.size()) {
            this.fakeDb = new HashMap<>();
        }

        Item newItem = new Item();
        newItem.setId(1);
        newItem.setDesc("first");

        System.out.println("Create OK :" + newItem.getId());

        this.fakeDb.put(newItem.getId(), newItem);
    }

    public Item getItem(int id) {
        if (this.fakeDb == null || 1 > this.fakeDb.size() || this.fakeDb.get(id) == null) {
            return new Item(0, "no!");
        }

        return this.fakeDb.get(id);
    }


}
