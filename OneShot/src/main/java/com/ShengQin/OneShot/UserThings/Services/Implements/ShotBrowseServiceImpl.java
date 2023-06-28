package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.ShotMapper;
import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import com.ShengQin.OneShot.UserThings.Services.ShotBrowseService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShotBrowseServiceImpl implements ShotBrowseService {
    @Autowired
    ShotMapper shotMapper;
    @Autowired
    PreferenceService preferenceService;
    @Autowired
    UserService userService;
    @Override
    public List<Shot> getRecommendPage(int user_id, int pageNum) {
        List<Shot> shots = new ArrayList<Shot>();
        List<String> tags = preferenceService.getPreferences(user_id);
        /**---------------------------------------------------获取shot们--------------------------------------------------*/
        if (tags.isEmpty()){//用户未设置喜好
            PageHelper.startPage(pageNum,PAGE_SIZE);
            shots=shotMapper.getShotIgnorePreferenceHigh();
            if (shots.isEmpty()) {//如果高浏览点赞比的都看完了
//                PageInfo<Integer> pageInfo = new PageInfo<>(shots);
//                int shotIgnoresPreferenceHighTotal = (int) pageInfo.getTotal();
                int shotIgnoresPreferenceHighTotal = shotMapper.getShotIgnoresPreferenceHighTotal();
                int maxPage = shotIgnoresPreferenceHighTotal/PAGE_SIZE + 1;//获得不匹配用户喜好但高浏览点赞比的shot的最大页数
                pageNum-=maxPage;//获取查询low的页码
                PageHelper.startPage(pageNum,PAGE_SIZE);
                shots = shotMapper.getShotIgnorePreferenceLow();
            }
        }
        else {
            PageHelper.startPage(pageNum,PAGE_SIZE);
            shots = shotMapper.getShotMatchesPreferenceHigh(tags);
            PageInfo<Shot> pageInfo = new PageInfo<Shot>(shots);
            if (shots.isEmpty()) {//如果符合喜好且高浏览点赞比的都看完了
                int shotMatchesPreferenceHighTotal = (int) pageInfo.getTotal();
                System.out.println(shotMatchesPreferenceHighTotal+"------------------------------------------------");
//                int shotMatchesPreferenceHighTotal = shotMapper.getShotMatchesPreferenceHighTotal(tags,user_id);
                int maxPage = shotMatchesPreferenceHighTotal/PAGE_SIZE + 1;//获得不匹配用户喜好但高浏览点赞比的shot的最大页数
                pageNum-=maxPage;//获取查询low的页码
                PageHelper.startPage(pageNum,PAGE_SIZE);
                shots = shotMapper.getShotMatchesPreferenceLow(tags);
            }
        }
        for (Shot shot :
                shots) {
            String userName = userService.getUserName(shot.getUser_id());
            shot.setUserName(userName);
        }
        return shots;
    }
}
