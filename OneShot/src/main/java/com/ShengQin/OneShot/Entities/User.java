package com.ShengQin.OneShot.Entities;

import com.ShengQin.OneShot.Utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
public class User {
    private String userName;
    private Integer id;
    private Gender gender;
    private int age;
    private String personalSignature;

    /**一定要有无参构造函数！不然mybatis只能根据全参构造按顺序对应*/
    public User(){}

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
