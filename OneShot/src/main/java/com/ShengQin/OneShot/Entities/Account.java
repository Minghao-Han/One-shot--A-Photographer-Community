package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private int id;
    private String email;
    private String password;

    public Account(String email, String password) {//id在mysql设置乘auto increase
        this.email = email;
        this.password = password;
    }
}
