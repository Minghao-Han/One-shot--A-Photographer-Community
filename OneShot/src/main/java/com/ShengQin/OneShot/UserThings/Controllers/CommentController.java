package com.ShengQin.OneShot.UserThings.Controllers;

import com.ShengQin.OneShot.Entities.Comment;
import com.ShengQin.OneShot.UserThings.Services.CommentService;
import com.ShengQin.OneShot.Utils.UserId;
import com.ShengQin.OneShot.VO.CommentVO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.ShengQin.OneShot.Utils.Result;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    @Qualifier("shotCommentServiceImpl")
    private CommentService shotCommentServiceImpl;
    @Autowired
    @Qualifier("postCommentServiceImpl")
    private CommentService postCommentServiceImpl;

    /**shot评论*/
    @PostMapping("/shot")
    public String makeCommentOnShot(@RequestBody Map<String,Object> requestBody, @UserId int commentator_id){
        String content = (String) requestBody.get("content");
        int shot_id = (int) requestBody.get("shot_id");
        int parent_id = (int) requestBody.get("parent_id");
        int receiver_id = (int) requestBody.get("receiver_id");
        boolean serviceResult = shotCommentServiceImpl.createComment(shot_id,parent_id,commentator_id,content,receiver_id);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }

    @DeleteMapping("/shot")
    public String deleteCommentOfShot(@RequestBody Map<String,Integer> requestBody){
        int shot_id = requestBody.get("shot_id");
        int innerID = requestBody.get("innerID");
//        System.out.println(shot_id);
//        System.out.println(innerID);
        boolean serviceResult = shotCommentServiceImpl.deleteComment(innerID,shot_id);
        if (serviceResult) return Result.success("删除评论成功");
        else return Result.fail("删除评论失败");
    }

    @GetMapping("/shot/{shot_id}/{pageNum}")
    public String shotGetMoreComment(@PathVariable("shot_id")int shot_id,@PathVariable("pageNum")int pageNum){
        List<CommentVO> commentVOs = shotCommentServiceImpl.getComments(shot_id,pageNum);
        return Result.success("获得下一页评论成功",commentVOs);
    }

    /**post*/
    @PostMapping("/post")
    public String makeCommentOnPost(@RequestBody Map<String,Object> requestBody,@UserId int commentator_id){
        String content = (String) requestBody.get("content");
        int post_id = (int) requestBody.get("post_id");
        int parent_id = (int) requestBody.get("parent_id");
        int receiver_id = (int) requestBody.get("receiver_id");
        boolean serviceResult = postCommentServiceImpl.createComment(post_id,parent_id,commentator_id,content,receiver_id);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }
    @DeleteMapping("/post")
    public String deleteCommentOfPost(@RequestBody Map<String,Integer> requestBody){
        int shot_id = requestBody.get("post_id");
        int comment_id = requestBody.get("comment_id");
        boolean serviceResult = postCommentServiceImpl.deleteComment(comment_id,shot_id);
        if (serviceResult) return Result.success("评论成功");
        else return Result.fail("评论失败");
    }
    @GetMapping("/post/{post_id}/{pageNum}")
    public String postGetMoreComment(@PathVariable("post_id")int post_id,@PathVariable("pageNum")int pageNum){
        List<CommentVO> commentVOs = postCommentServiceImpl.getComments(post_id,pageNum);
        return Result.success("获得下一页评论成功",commentVOs);
    }
}
