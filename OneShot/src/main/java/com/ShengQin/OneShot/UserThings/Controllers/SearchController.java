package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.UserThings.Services.FuzzySearchService;
import com.ShengQin.OneShot.Utils.Result;
import com.ShengQin.OneShot.Utils.UserId;
import com.ShengQin.OneShot.VO.ShotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    FuzzySearchService fuzzySearchService;
    public String searchShots(@UserId int user_id, Map<String,Object> requestMap){
        String searchContent = (String) requestMap.get("searchContent");
        List<ShotVO> searchResult = fuzzySearchService.search(searchContent,user_id);
        if (searchResult.isEmpty())return Result.fail("未搜索到内容");
        else return Result.success("成功搜索到",searchResult);
    }
}
