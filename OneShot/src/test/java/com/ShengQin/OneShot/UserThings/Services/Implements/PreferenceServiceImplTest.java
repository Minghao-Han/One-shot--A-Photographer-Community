package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PreferenceServiceImplTest {
    @Autowired
    PreferenceService preferenceService;

    @Test
    void addPreferences() {
        List<String> tags = new ArrayList<String>();
        tags.add("风光");
        tags.add("足球");
        tags.add("街拍");
        tags.add("人像");
        tags.add("美女");
        tags.add("黑白");
        preferenceService.addPreferences(tags,4);
    }

    @Test
    void removePreference() {
        preferenceService.removePreference("美女",4);
    }

    @Test
    void getPreferences() {
        List<String> tags = preferenceService.getPreferences(4);
        for (String tag :
                tags) {
            System.out.println(tag);
        }
    }
}