package com.ShengQin.OneShot.Entities;

import com.ShengQin.OneShot.Utils.Gender;
import lombok.Data;



@Data
public class User {
    private String userName;
    private Integer id;
    private Gender gender;
    private int age;
    private String personalSignature;

    public User(String userName, Integer id, Gender gender, int age, String personalSignature) {
        this.userName = userName;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.personalSignature = personalSignature;
    }

    public User(String userName, Gender gender, int age, String personalSignature) {
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.personalSignature = personalSignature;
    }

    public User(String userName, Integer id) {
        this.userName = userName;
        this.id = id;
        gender=Gender.Unknown;
        personalSignature=null;
    }
}
