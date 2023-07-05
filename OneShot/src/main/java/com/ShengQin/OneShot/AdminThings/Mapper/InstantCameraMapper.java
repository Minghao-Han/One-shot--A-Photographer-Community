package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.Entities.InstantCamera;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstantCameraMapper {
    //用户端后端
    @Select("SELECT * FROM instant_camera")
    @Results(id="instant_camera1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="image_format", property="image_format"),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),
    })
    List<InstantCamera> findAll();

    @Insert("INSERT INTO instant_camera(id, name,sensor_format,sensor_type,sensor_size,total_pixels,image_format ) VALUES " +
            "(#{id}, #{name}, #{sensor_format}, " +
            "#{sensor_type}, #{sensor_size},#{total_pixels},#{image_format})")
    int insert(InstantCamera instantCamera);




    @Select("SELECT * from  instant_camera  limit #{pageNum},  #{pageSize}")
    @Results(id="instant_camera2", value={
            @Result(column="id", property="id", id=true),
            @Result(column="image_format", property="image_format"),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),

    })
    List<InstantCamera> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*)  from instant_camera ")
    Integer selectTotal();

    //删除
    @Delete("delete from instant_camera where id= #{id}")
    int  deleteById(@Param("id") Integer id);



    //洗澡
    @Update("UPDATE instant_camera set id = #{id}, name = #{name},sensor_format=#{sensor_format},sensor_type=#{sensor_type}," +
            " sensor_size=#{sensor_size},total_pixels=#{total_pixels},image_format=#{image_format} where id= #{id}")
    int update(InstantCamera instantCamera);

    @Select("select count(*) from instant_camera where id = #{id}")
    public boolean isExist1(Integer id);


    @Select("SELECT  * from  instant_camera where id like CONCAT('%', #{id}, '%')")
    List<InstantCamera> selectPage1(int id);

    @Select("SELECT count(*)  from instant_camera  where  id=#{id}")
    Integer selectTotal1(int id);

    //客户端

    @Results(id="instant_camera3", value={
            @Result(column="id", property="id", id=true),
            @Result(column="image_format", property="image_format"),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),

    })
    @Select("SELECT * FROM instant_camera where name = #{name}")
    List<InstantCamera> findParam(@Param("name") String name);
}
