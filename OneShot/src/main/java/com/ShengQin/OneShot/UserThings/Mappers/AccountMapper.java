package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    public default boolean save(Account account){
        if (this.isExist(account)){
            if (this.emailExist(account)) return false;
            else {
                update(account);
                return true;
            }
        }else {
            insert(account);
            return true;
        }
    }

    @Insert("insert into account(email,password) values (#{email},#{password})")
    public void insert(Account account);

    @Select("select count(*) from account where email = #{email}")
    public boolean emailExist(Account account);
    @Select("select count(*) from account where id = #{id}")
    public boolean isExist(Account account);

    @Update("update account set email=#{email},password=#{password} where id=#{id}")
    public void update(Account account);
     public void delete(Account account);
     @Select("select password from account where email = #{email}")
     public String getPassword(String email);
    @Select("select id from account where email = #{email}")
     public int getId(String email);
}
