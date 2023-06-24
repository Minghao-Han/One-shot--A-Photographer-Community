package com.ShengQin.OneShot.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Administrator {
    private String password;
    private String adminName;
    private int id;
}
