package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

//mybatis数据接口
@Mapper
public interface AdminUserMapper {

//    //登录相关
//    @Select("SELECT * FROM account WHERE email = #{email} AND password = #{password}")
//    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password) ;

    //查找
    @Select("SELECT * FROM account")
    List<Account> findAll();

    //插入相关
    @Insert("INSERT INTO account(email, password) VALUES (#{email}, #{password})")
    int insert(Account account);




    //更新相关(用email来改可能有一点问题，必须要有email，在更新时需要在原有基础上修改，否则有部分为0
    // 中午尝试一下mybatis动态update）
    @Select("select count(*) from account where id = #{id}")
    public boolean isExist(int id);

    @Select("select count(*) from account where email = #{email}")
    public boolean isExist1(String email);
@Update("UPDATE account set email = #{email}, password = #{password} where email= #{email}")
    int  update(Account account);

@Delete("delete from account where email = #{email}")
    int  deleteByEmail(@Param("email") String email);



//加一个参数写两遍，记得改sql语句
@Select("SELECT * from  account  limit #{pageNum},  #{pageSize}")
    List<Account> selectPage(Integer pageNum, Integer pageSize);

@Select("SELECT count(*)  from account  ")
    Integer selectTotal();

//查询测试
    @Select("SELECT  * from  account where email like CONCAT('%', #{email}, '%') limit #{pageNum}, #{pageSize}")
    List<Account> selectPage1(Integer pageNum, Integer pageSize, String email);

    @Select("SELECT count(*)  from account  where  email=#{email}")
    Integer selectTotal1(String email);

    //给关联的外键加上on delete cascade，后面再弄
    @Delete("<script>delete from account where " +
            "<foreach collection = 'emails' item='email' separator='or'>" +
            "email = #{email}" +
            "</foreach>" +
            "</script>")
    boolean removeByEmails(List<String> emails);
}
