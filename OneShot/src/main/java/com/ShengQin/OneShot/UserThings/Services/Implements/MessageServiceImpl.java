package com.ShengQin.OneShot.UserThings.Services.Implements;

import com.ShengQin.OneShot.UserThings.Mappers.PostMessageMapper;
import com.ShengQin.OneShot.UserThings.Mappers.ShotMessageMapper;
import com.ShengQin.OneShot.UserThings.Services.PostService;
import com.ShengQin.OneShot.UserThings.Services.ShotService;
import com.ShengQin.OneShot.UserThings.Services.UserService;
import com.ShengQin.OneShot.VO.Message;
import com.ShengQin.OneShot.VO.ThumbCommentMessageVO;
import com.ShengQin.OneShot.UserThings.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserService userService;

    @Autowired
    ShotService shotService;
    @Autowired
    PostService postService;

    @Autowired
    ShotMessageMapper shotMessageMapper;
    @Autowired
    PostMessageMapper postMessageMapper;

    @Override
    public List<Message> getUncheckMessages(int user_id) {
        List<Message> uncheckMessages = new ArrayList<>();
        /**获取未读shot点赞信息*/
        List<Map<String, Object>> uncheckShotThumbMessages = shotMessageMapper.getUncheckThumbMessage(user_id);
        List<Integer> readShotThumbMessageIds = new ArrayList<>();//将要设为已读的shot thumb message的id
        for (Map<String, Object> uncheckShotThumbMessage:uncheckShotThumbMessages) {
            int shot_id = ((Long)uncheckShotThumbMessage.get("shot_id")).intValue();
            String title = shotService.getShot(shot_id).getTitle();
            int from_id = ((Long)uncheckShotThumbMessage.get("thumber_id")).intValue();
            String from_userName = userService.getUserName(from_id);
            int id = ((Long)uncheckShotThumbMessage.get("id")).intValue();
            Date time = (Date)uncheckShotThumbMessage.get("time");
            ThumbCommentMessageVO uncheckShotThumbMessageVO = new ThumbCommentMessageVO(title,from_id,from_userName,THUMB,SHOT,null,time,id);
            /**添加进未读消息list*/
            uncheckMessages.add(new Message("点赞了你的shot",uncheckShotThumbMessageVO,time));
            readShotThumbMessageIds.add(id);
        }
        /**将shot thumb消息置已读*/
        shotMessageMapper.checkThumbMessage(readShotThumbMessageIds);

        /**获取未读shot评论信息*/
        List<Integer> readShotCommentMessageIds = new ArrayList<>();//将要设为已读的shot thumb message的id
        List<Map<String, Object>> uncheckShotCommentMessages = shotMessageMapper.getUncheckCommentMessage(user_id);
        for (Map<String, Object> uncheckShotCommentMessage:uncheckShotCommentMessages) {
            int shot_id = ((Long)uncheckShotCommentMessage.get("shot_id")).intValue();
            String title = shotService.getShot(shot_id).getTitle();
            int from_id = ((Long)uncheckShotCommentMessage.get("commentator_id")).intValue();
            String from_userName = userService.getUserName(from_id);
            int id = ((Long)uncheckShotCommentMessage.get("id")).intValue();
            Date time = (Date)uncheckShotCommentMessage.get("time");
            String content = (String)uncheckShotCommentMessage.get("content");
            ThumbCommentMessageVO uncheckShotCommentMessageVO = new ThumbCommentMessageVO(title,from_id,from_userName,COMMENT,SHOT,content,time,id);
            uncheckMessages.add(new Message<>("评论了你的shot",uncheckShotCommentMessageVO,time));
            readShotCommentMessageIds.add(id);
        }
        shotMessageMapper.checkCommentMessage(readShotCommentMessageIds);
//        /**获取未读post点赞信息*/
//        List<Map<String, Object>> uncheckPostCommentMessages = postMessageMapper.getUncheckCommentMessage(user_id);
//        for (Map<String, Object> uncheckPostThumbMessage:uncheckPostCommentMessages) {
//            int post_id = (int)uncheckPostThumbMessage.get("post_id");
//            String title = postService.
//            int from_id = (int)uncheckPostThumbMessage.get("thumber_id");
//            String from_userName = userService.getUserName(from_id);
//            int id = (int)uncheckPostThumbMessage.get("id");
//            Date time = (Date)uncheckPostThumbMessage.get("time");
//            ThumbCommentMessageVO uncheckShotThumbMessageVO = new ThumbCommentMessageVO(title,from_id,from_userName,THUMB,POST,null);
//            uncheckThumbCommentMessageVOS.add(uncheckShotThumbMessageVO);
//        }
        uncheckMessages.sort(Comparator.comparing(Message::getTime));
        return uncheckMessages;
    }

    @Override
    public List<ThumbCommentMessageVO> getHistoryMessage(int user_id, int pageNum) {
        return null;
    }
}
