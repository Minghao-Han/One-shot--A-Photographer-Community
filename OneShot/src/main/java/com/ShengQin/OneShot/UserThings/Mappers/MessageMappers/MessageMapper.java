package com.ShengQin.OneShot.UserThings.Mappers.MessageMappers;

import com.ShengQin.OneShot.VO.MessageVO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MessageMapper {//从message表获取数据
    @Update("<script>UPDATE message set checked = true where" +
            "<foreach collection='checkedIds' item ='id' separator='or'>" +
            "id = #{id}" +
            "</foreach></script>")
    public void setMessageChecked(@Param("checkedIds") List<Integer> checkedIds);
    @Select("select id,message_type,references_id,time from message where checked=false and receiver_id=#{receiver_id}")
    public List<MessageVO> getUncheckMessageVOs1(int receiver_id);
    public default List<MessageVO> getUncheckMessageVOs(int` receiver_id){
        List<MessageVO> messageVOs = this.getUncheckMessageVOs1(receiver_id);
        if (!messageVOs.isEmpty()){
            List<Integer> checkedIds = new ArrayList<>();
            for (MessageVO messageVO:messageVOs) {
                checkedIds.add(messageVO.getId());
            }
            setMessageChecked(checkedIds);
            return messageVOs;
        }
        return messageVOs;
    }

    @Select("select id,message_type,references_id,time from message where receiver_id=#{receiver_id} order by time desc")
    public List<MessageVO> getHistoryMessageVOs(int receiver_id);

    @Insert("insert into message(message_type,references_id,receiver_id) values(#{messageType},#{references_id},#{receiver_id})")
    public void createMessage(String messageType,int references_id,int receiver_id);
    @Delete("delete from message where message_type=#{messageType} and references_id=#{references_id}")
    public void deleteMessage(String messageType,int references_id);
}
