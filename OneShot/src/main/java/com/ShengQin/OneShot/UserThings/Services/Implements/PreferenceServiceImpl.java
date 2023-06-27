package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.TagMapper;
import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    @Autowired
    TagMapper tagMapper;
    @Override
    public boolean addPreference(String tag, int user_id) {
        tagMapper.addPreference(tag, user_id);
        return true;
    }

    @Override
    public boolean addPreferences(List<String> tags, int user_id) {
        tagMapper.addPreferences(tags, user_id);
        return true;
    }

    @Override
    public boolean removePreference(String tag, int user_id) {
        if (!tagMapper.preferenceExist(tag, user_id))return false;
        else {
            tagMapper.removePreference(tag, user_id);
            return true;
        }
    }

    @Override
    public boolean removePreferences(List<String> tags, int user_id) {
        return false;
    }

    @Override
    public List<String> getPreferences(int user_id) {
        return tagMapper.getPreference(user_id);
    }
}
