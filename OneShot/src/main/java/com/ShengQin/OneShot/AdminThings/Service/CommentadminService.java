package com.ShengQin.OneShot.AdminThings.Service;

import com.ShengQin.OneShot.AdminThings.Mapper.CommentadminMapper;
import com.ShengQin.OneShot.Entities.Commentadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentadminService {
    @Autowired
    CommentadminMapper commentadminMapper;

    public int save(Commentadmin commentadmin) {
        //Optional<Integer> idOptional = Optional.ofNullable(user.getId());
        if (!commentadminMapper.isExist1(commentadmin.getId())) {
            System.out.println("111");
            return  commentadminMapper.insert(commentadmin);
        } else {
            System.out.println("222");
            return   commentadminMapper.update(commentadmin);
        }
    }
}
