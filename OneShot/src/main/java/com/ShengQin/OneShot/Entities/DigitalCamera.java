package com.ShengQin.OneShot.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DigitalCamera {
private int id;
private String name;
private String Sensor_format;
private String Sensor_type;
private String Sensor_size;
private String Total_pixels;
private String image_format;
}
