package com.ShengQin.OneShot.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private int logID;
    private int userID;//用户编号
    private String Log_Content;//操作内容',
    private String IP_Address;//登陆IP地址',
    private String OS;//用户电脑操作系统 ',
    private String IE;//用户用的浏览器',
    private Date CreateDate;//登录时间
    private String Remark;

}
