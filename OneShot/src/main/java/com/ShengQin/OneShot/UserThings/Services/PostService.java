package com.ShengQin.OneShot.UserThings.Services;

import com.ShengQin.OneShot.Entities.Post;
import com.ShengQin.OneShot.Entities.Shot;

import java.util.Date;
import java.util.List;

public interface PostService {
    public Post getPost(int post_id);
    public boolean isExist(Post post);
    public boolean isExist(int post_id);
    public void save(Post post);
    public void delete(int post_id);

    public void createPost(int user_id, String title, String content, Date time);
    public void addThumb(int post_id);
    public void addCollect(int post_id);
    public void subThumb(int post_id);
    public void subCollect(int post_id);
}
