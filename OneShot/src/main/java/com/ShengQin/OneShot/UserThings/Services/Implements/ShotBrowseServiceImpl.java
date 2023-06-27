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
        List<Integer> shot_ids = new ArrayList<Integer>();
        List<String> tags = preferenceService.getPreferences(user_id);
        /**---------------------------------------------------获取shot_id们--------------------------------------------------*/
        if (tags.isEmpty()){//用户未设置喜好
            PageHelper.startPage(pageNum,PAGE_SIZE);
            shot_ids=shotMapper.getShotIgnorePreferenceHigh(pageNum);
            if (shot_ids.isEmpty()) {//如果高浏览点赞比的都看完了
//                PageInfo<Integer> pageInfo = new PageInfo<>(shot_ids);
//                int shotIgnoresPreferenceHighTotal = (int) pageInfo.getTotal();
                int shotIgnoresPreferenceHighTotal = shotMapper.getShotIgnoresPreferenceHighTotal(user_id);
                int maxPage = shotIgnoresPreferenceHighTotal/PAGE_SIZE + 1;//获得不匹配用户喜好但高浏览点赞比的shot的最大页数
                pageNum-=maxPage;//获取查询low的页码
                PageHelper.startPage(pageNum,PAGE_SIZE);
                shot_ids = shotMapper.getShotIgnorePreferenceLow(pageNum);
            }
        }
        else {
            PageHelper.startPage(pageNum,PAGE_SIZE);
            shot_ids = shotMapper.getShotMatchesPreferenceHigh(tags,pageNum);
            if (shot_ids.isEmpty()) {//如果符合喜好且高浏览点赞比的都看完了
                PageInfo<Integer> pageInfo = new PageInfo<>(shot_ids);
                int shotMatchesPreferenceHighTotal = (int) pageInfo.getTotal();
//                int shotMatchesPreferenceHighTotal = shotMapper.getShotMatchesPreferenceHighTotal(tags,user_id);
                int maxPage = shotMatchesPreferenceHighTotal/PAGE_SIZE + 1;//获得不匹配用户喜好但高浏览点赞比的shot的最大页数
                pageNum-=maxPage;//获取查询low的页码
                PageHelper.startPage(pageNum,PAGE_SIZE);
                shot_ids = shotMapper.getShotMatchesPreferenceLow(tags,pageNum);
            }
        }
        /**---------------------------------------------------获取shot们--------------------------------------------------*/
        for (int shot_id :shot_ids) {
            Shot shot = shotMapper.getShot(shot_id);
            /**-----获取shot主人的user name------*/
            String userName = userService.getUserName(user_id);
            shot.setUserName(userName);
            shots.add(shot);
        }
        return shots;
    }
}
