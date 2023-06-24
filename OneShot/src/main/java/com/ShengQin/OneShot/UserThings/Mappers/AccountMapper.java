package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    public default void save(Account account){
        if (isExist(account)){
            update(account);
        }else {
            insert(account);
        }
    }
    public void insert(Account account);
    public boolean isExist(Account account);
    public void update(Account account);
     public void delete(Account account);
     @Select("select password from account where email = #{email}")
     public String getPassword(String email);
}
