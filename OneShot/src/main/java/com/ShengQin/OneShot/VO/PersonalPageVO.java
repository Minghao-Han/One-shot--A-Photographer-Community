package com.ShengQin.OneShot.VO;

import com.ShengQin.OneShot.Entities.User;
import com.ShengQin.OneShot.Utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPageVO {
    private int userId;
    private String userName;
    private String email;
    private String personalSignature;
    private Gender gender;
    private int age;
    private int totalReceivedThumbs;
    private int totalFancies;
    private int totalSubscriptions;

    public PersonalPageVO(User user) {
        this.userId=user.getId();
        this.userName = user.getUserName();
        this.personalSignature = user.getPersonalSignature();
        this.gender = user.getGender();
        this.age = user.getAge();
    }
}
