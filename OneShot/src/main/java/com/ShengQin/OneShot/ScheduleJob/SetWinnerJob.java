package com.ShengQin.OneShot.ScheduleJob;

import com.ShengQin.OneShot.Utils.SpringContextUtil;
import jakarta.annotation.PostConstruct;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class SetWinnerJob implements Job {//在启动定时任务开始执行的时候就会报空指针异常，原因是任务类是反射创建的，没有交给Spring容器管理。
    GameScheduleMapper gameScheduleMapper;
    Integer game_id;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        gameScheduleMapper = (GameScheduleMapper) SpringContextUtil.getBean("gameScheduleMapper");
        game_id = jobExecutionContext.getJobDetail().getJobDataMap().getInt("game_id");
        Integer winner_id = gameScheduleMapper.selectWinner(game_id);
        if (winner_id!=null) gameScheduleMapper.setWinner(winner_id,game_id);//有winner
        else gameScheduleMapper.setWinner(0,game_id);//无人参加比赛，即无winner。设置is_selected为true避免每次都为这个比赛找winner
        System.out.println("为"+game_id+"找winner");
    }
}
