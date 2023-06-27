package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.Security.TokenUtil;
import com.ShengQin.OneShot.UserThings.Services.PostCommentService;
import com.ShengQin.OneShot.UserThings.Services.ShotCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ShengQin.OneShot.Utils.Result;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ShotCommentService shotCommentService;
    @Autowired
    PostCommentService postCommentService;

    /**shot评论*/
    @PostMapping("/shot")
    public String makeCommentOnShot(@RequestBody Map<String,Object> requestBody){
        String content = (String) requestBody.get("content");
        int commentator_id = (int) requestBody.get("commentator_id");
        int shot_id = (int) requestBody.get("shot_id");
        int parent_id = (int) requestBody.get("parent_id");
        boolean serviceResult = shotCommentService.createComment(shot_id,parent_id,commentator_id,content);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }

    @DeleteMapping("/shot")
    public String deleteCommentOfShot(@RequestBody Map<String,Integer> requestBody){
        int shot_id = requestBody.get("shot_id");
        int innerID = requestBody.get("innerID");
//        System.out.println(shot_id);
//        System.out.println(innerID);
        boolean serviceResult = shotCommentService.deleteComment(innerID,shot_id);
        if (serviceResult) return Result.success("删除评论成功");
        else return Result.fail("删除评论失败");
    }

    @GetMapping("/shot/{shot_id}/{pageNum}")
    public String shotGetMoreComment(@PathVariable("shot_id")int shot_id,@PathVariable("pageNum")int pageNum){
        List<Comment> comments = shotCommentService.getComments(shot_id,pageNum);
        return Result.success("获得下一页评论成功",comments);
    }

    /**post*/
    @PostMapping("/post")
    public String makeCommentOnPost(@RequestBody Map<String,Object> requestBody){
        String content = (String) requestBody.get("content");
        int commentator_id = (int) requestBody.get("commentator_id");
        int post_id = (int) requestBody.get("post_id");
        int parent_id = (int) requestBody.get("parent_id");
        Date time = (Date) requestBody.get("time");
        boolean serviceResult = postCommentService.createComment(post_id,parent_id,commentator_id,time,content);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }
    @DeleteMapping("/post")
    public String deleteCommentOfPost(@RequestBody Map<String,Integer> requestBody){
        int shot_id = requestBody.get("post_id");
        int comment_id = requestBody.get("comment_id");
        boolean serviceResult = postCommentService.deleteComment(comment_id,shot_id);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }
    @GetMapping("/shot/{post_id}/{pageNum}")
    public String postGetMoreComment(@PathVariable("post_id")int post_id,@PathVariable("pageNum")int pageNum){
        List<Comment> comments = postCommentService.getComments(post_id,pageNum);
        return Result.success("获得下一页评论成功",comments);
    }
}
