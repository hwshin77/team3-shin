package com.mobigen.shinhw.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;

    private String desc;


    public void updateDesc(String desc) {
        this.desc = desc;
    }
}
