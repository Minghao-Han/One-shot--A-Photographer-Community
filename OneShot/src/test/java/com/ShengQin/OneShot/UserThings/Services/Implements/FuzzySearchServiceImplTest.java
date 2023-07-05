package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.FuzzySearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FuzzySearchServiceImplTest {
    @Autowired
    FuzzySearchService fuzzySearchService;

    @Test
    void search() {
        System.out.println(fuzzySearchService.search("钓鱼",4));
    }
}