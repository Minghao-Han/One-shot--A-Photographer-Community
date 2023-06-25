package com.ShengQin.OneShot.UserThings.Services;

import java.util.List;

public interface PreferenceService {
    public boolean addPreference(String tag,int user_id);
    public boolean addPreferences(List<String> tags,int user_id);//多用这个
    public boolean removePreference(String tag,int user_id);
    public boolean removePreferences(List<String> tags,int user_id);//多用这个
    public List<String> getPreferences(int user_id);
}
