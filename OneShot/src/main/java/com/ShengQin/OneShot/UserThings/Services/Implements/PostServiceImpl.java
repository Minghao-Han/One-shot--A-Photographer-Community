package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.Entities.Post;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Post getPost(int post_id) {
        return null;
    }

    @Override
    public boolean isExist(Post post) {
        return false;
    }

    @Override
    public boolean isExist(int post_id) {
        return false;
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void delete(int post_id) {

    }

    @Override
    public void createPost(int user_id, String title, String content, Date time) {

    }

    @Override
    public void addThumb(int post_id) {

    }

    @Override
    public void addCollect(int post_id) {

    }

    @Override
    public void subThumb(int post_id) {

    }

    @Override
    public void subCollect(int post_id) {

    }
}
