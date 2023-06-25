package com.ShengQin.OneShot.Entities;

import com.ShengQin.OneShot.Utils.IdGenerator;
import lombok.Data;

@Data
public class Account {
    private int id;
    private String email;
    private String password;

    public Account(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

   public Account newAccount(String email, String password){
        int id = IdGenerator.newUserID();
        return new Account(id,email,password);
   }
}
