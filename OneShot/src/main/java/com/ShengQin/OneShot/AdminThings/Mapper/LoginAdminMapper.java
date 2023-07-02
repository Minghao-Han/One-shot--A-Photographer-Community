package com.ShengQin.OneShot.AdminThings.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginAdminMapper {
    @Select("select password from admin_account where email=#{email}")
    public String getPassword(String email);
    @Select("select id from admin_account where email=#{email}")
    public int getId(String email);
}
