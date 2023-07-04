package com.ShengQin.OneShot.AdminThings.Mapper;

import com.ShengQin.OneShot.Entities.DigitalCamera;
import com.ShengQin.OneShot.Entities.Shotadmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DigitalCameraMapper {

    //用户端后端
    @Select("SELECT * FROM digital_camera")
    @Results(id="digital_camera1", value={
            @Result(column="id", property="id", id=true),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),

            @Result(column="image_format", property="image_format")
    })
    List<DigitalCamera> findAll();

    @Insert("INSERT INTO digital_camera(id, name,sensor_format,sensor_type,sensor_size,total_pixels,image_format ) VALUES " +
            "(#{id}, #{name}, #{sensor_format}, " +
            "#{sensor_type}, #{sensor_size},#{total_pixels},#{image_format})")
    int insert(DigitalCamera digitalCamera);




    @Select("SELECT * from  digital_camera  limit #{pageNum},  #{pageSize}")
    @Results(id="digital_camera2", value={
            @Result(column="id", property="id", id=true),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),

            @Result(column="image_format", property="image_format")
    })
    List<DigitalCamera> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*)  from digital_camera ")
    Integer selectTotal();

    //删除
    @Delete("delete from digital_camera where id= #{id}")
    int  deleteById(@Param("id") Integer id);



    //洗澡
    @Update("UPDATE digital_camera set id = #{id}, name = #{name},sensor_format=#{sensor_format},sensor_type=#{sensor_type}," +
            " sensor_size=#{sensor_size},total_pixels=#{total_pixels},image_format=#{image_format} where id= #{id}")
    int update(DigitalCamera digitalCamera);

    @Select("select count(*) from digital_camera where id = #{id}")
    public boolean isExist1(Integer id);


    @Select("SELECT  * from  digital_camera where id like CONCAT('%', #{id}, '%')")
    List<DigitalCamera> selectPage1(int id);

    @Select("SELECT count(*)  from digital_camera  where  id=#{id}")
    Integer selectTotal1(int id);

    //客户端

    @Results(id="digital_camera3", value={
            @Result(column="id", property="id", id=true),
            @Result(column="name", property="name"),
            @Result(column="sensor_format", property="Sensor_format"),
            @Result(column="sensor_type", property="Sensor_type"),
            @Result(column="sensor_size", property="Sensor_size"),
            @Result(column="total_pixels", property="Total_pixels"),

            @Result(column="image_format", property="image_format")
    })
    @Select("SELECT * FROM digital_camera where name = #{name}")
    List<DigitalCamera> findParam(@Param("name") String name);
}
