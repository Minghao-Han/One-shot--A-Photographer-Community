package com.ShengQin.OneShot.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SimilarityUtilTest {
    @Autowired
    SimilarityUtil similarityUtil;

    @Test
    void getJaccardSimilarityBetweenText() {
        System.out.println(similarityUtil.getJaccardSimilarityBetweenText("我喜欢足球","他喜欢足球"));
        System.out.println(similarityUtil.getJaccardSimilarityBetweenText("我喜欢踢足球","呃呃"));
    }
}