package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Shot;
import com.ShengQin.OneShot.UserThings.Mappers.TagMapper;
import com.ShengQin.OneShot.UserThings.Services.FuzzySearchService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.ShotVOService;
import com.ShengQin.OneShot.Utils.SimilarityUtil;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuzzySearchServiceImpl implements FuzzySearchService {
    @Autowired
    ShotService shotService;
    @Autowired
    ShotVOService shotVOService;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    SimilarityUtil similarityUtil;

    @Override
    public List<ShotVO> search(String searchContent,int user_id) {
        List<ShotVO> searchResult = new ArrayList<>();
        List<Shot> allShots = shotService.getAllShots();
        for (Shot shot:allShots) {
            StringBuilder text = new StringBuilder();
            text.append(shot.getTitle()).append(shot.getContent());
            List<String> tags = tagMapper.getTagsOfShot(shot.getId());
            for (String tag:tags) {
                text.append(tag);
            }
            double similarity = similarityUtil.getJaccardSimilarityBetweenText(searchContent,text.toString());
            if (similarity>=0.1) {
                ShotVO shotVO = shotVOService.createShotVO(shot,user_id);
                searchResult.add(shotVO);
            }
        }
        return searchResult;
    }
}
