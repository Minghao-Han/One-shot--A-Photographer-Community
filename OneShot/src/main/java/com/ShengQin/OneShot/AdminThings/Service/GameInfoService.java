package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.GameInfoMapper;
import com.ShengQin.OneShot.Entities.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInfoService {

    @Autowired
    private GameInfoMapper gameInfoMapper;

    public Integer save(GameInfo gameInfo) {
        if (!gameInfoMapper.isExist(gameInfo.getId())) {
            System.out.println("111");
            return  gameInfoMapper.insert(gameInfo);
        } else {
            System.out.println("222");
            return   gameInfoMapper.update(gameInfo);
        }
    }
}
