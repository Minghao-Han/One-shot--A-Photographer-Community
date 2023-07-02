package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.AdminGameInfoMapper;
import com.ShengQin.OneShot.Entities.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInfoService {

    @Autowired
    private AdminGameInfoMapper adminGameInfoMapper;

    public Integer save(GameInfo gameInfo) {
        if (!adminGameInfoMapper.isExist(gameInfo.getId())) {
            System.out.println("111");
            return  adminGameInfoMapper.insert(gameInfo);
        } else {
            System.out.println("222");
            return   adminGameInfoMapper.update(gameInfo);
        }
    }
}
