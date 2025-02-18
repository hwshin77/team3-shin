package com.mobigen.shinhw.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // new UserInfo()
@AllArgsConstructor // new UserInfo("id", "park", 40)
@Getter
@Setter
public class UserInfo {
    private int id;
    private String name;
    private String email;
    private String desc;
}
