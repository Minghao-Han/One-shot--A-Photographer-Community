package com.ShengQin.OneShot.UserThings.Mappers;

import com.ShengQin.OneShot.Entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public default void save(User user) {
        if (isExist(user)) update(user);
        else insert(user);
    }
    public boolean isExist(User user);
    public void update(User updatedUser);
    public void insert(User newUser);
}
