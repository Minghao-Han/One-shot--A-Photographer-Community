package com.ShengQin.OneShot.UserThings.Mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface LoginLogMapper {
    @Insert("insert into sys_log(userID,Log_Content,IP_Address,OS,IE,createDate,Remark)" +
            " values(#{userID}, #{Log_Content},#{IP_Address},#{OS},#{IE},#{createDate},#{Remark})")
    public void log(int userID, String Log_Content, String IP_Address, String OS, String IE,Date createDate,String Remark);
}
