package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Services.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    @Override
    public boolean addPreference(String tag, int user_id) {
        return false;
    }

    @Override
    public boolean addPreferences(List<String> tags, int user_id) {
        return false;
    }

    @Override
    public boolean removePreference(String tag, int user_id) {
        return false;
    }

    @Override
    public boolean removePreferences(List<String> tags, int user_id) {
        return false;
    }

    @Override
    public List<String> getPreferences(int user_id) {
        return null;
    }
}
