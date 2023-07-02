package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.GamePersonMapper;
import com.ShengQin.OneShot.Entities.GamePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamePersonService {
    @Autowired
    private GamePersonMapper gamePersonMapper;

    public Integer save(GamePerson gamePerson) {
        if (!gamePersonMapper.isExist(gamePerson.getId())) {
            System.out.println("111");
            return  gamePersonMapper.insert(gamePerson);
        } else {
            System.out.println("222");
            return   gamePersonMapper.update(gamePerson);
        }
    }
}
