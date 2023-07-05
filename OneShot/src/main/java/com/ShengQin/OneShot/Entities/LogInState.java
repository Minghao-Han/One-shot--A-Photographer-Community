package com.ShengQin.OneShot.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogInState {
    private int logID;
    private int userID;
    private String Log_Content;
    private String IP_Address;
    private String OS;
    private String IE;
    private Timestamp CreateDate;
    private String Remark;


}
