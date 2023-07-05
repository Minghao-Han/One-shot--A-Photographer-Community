package com.ShengQin.OneShot.Utils;

import com.hankcs.hanlp.dictionary.common.CommonSynonymDictionary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SimilarityUtilTest {
    @Autowired
    SimilarityUtil similarityUtil;

    @Test
    void getJaccardSimilarityBetweenText() {
        CommonSynonymDictionary.SynonymItem synonymItem = CoreSynonymDictionary.get("喜欢");
        System.out.println(synonymItem.synonymList.get(1).realWord);
    }

    @Test
    void testGetJaccardSimilarityBetweenText() {
        System.out.println(similarityUtil.getJaccardSimilarityBetweenText("我喜欢踢球","自己喜欢踢球"));
    }
}