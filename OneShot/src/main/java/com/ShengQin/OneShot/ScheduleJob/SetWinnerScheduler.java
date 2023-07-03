package com.ShengQin.OneShot.ScheduleJob;

import com.ShengQin.OneShot.Entities.GameInfo;
import com.ShengQin.OneShot.Utils.CronExpressionGenerator;
import com.ShengQin.OneShot.Utils.SpringContextUtil;
import jakarta.annotation.PostConstruct;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SetWinnerScheduler {
    @Autowired
    private GameScheduleMapper gameScheduleMapper;//@Autowired在@PostConstruct前执行，此处注入除了使用函数获取games，也是为了确保GameScheduleMapper已准备好

    @PostConstruct
    public void setWinner(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            System.out.println("scheduler started");
            System.out.println("clear scheduler");
            scheduler.clear();
            /**先为尚未结束的比赛加定时选winner任务*/
            List<GameInfo> unfinishedGames = gameScheduleMapper.getUnfinishedGames();
            System.out.println(unfinishedGames);
            int index = 0;//计数用，确保不同job的名字不一样
            for (GameInfo unfinishedGame :unfinishedGames) {
                String cronExpression = CronExpressionGenerator.getCronExpression(unfinishedGame.getEnd_time());
                System.out.println("新建job name =setWinnerJob"+index+"并添加进scheduler");
                scheduler.scheduleJob(
                        JobBuilder.newJob(SetWinnerJob.class)
                                .withIdentity("setWinnerJob"+index,"setWinnerGroup")
                                .usingJobData("game_id",unfinishedGame.getId())
                                .build()
                        ,
                        TriggerBuilder.newTrigger()
                                .withIdentity("setWinnerTrigger"+index,"setWinnerTriggerGroup")
                                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                                .build()
                        );
                index++;
            }
            /**再为已结束但没选冠军的比赛加选winner任务*/
            List<GameInfo> finishedNoWinnerGames = gameScheduleMapper.getFinishedNoWinnerGames();
            for (GameInfo finishedNoWinnerGame:finishedNoWinnerGames) {
                int game_id = finishedNoWinnerGame.getId();
                Integer winner_id = gameScheduleMapper.selectWinner(game_id);
                if (winner_id!=null) gameScheduleMapper.setWinner(winner_id,game_id);//有winner
                else gameScheduleMapper.setWinner(0,game_id);//无人参加比赛，即无winner。设置is_selected为true避免每次都为这个比赛找winner
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }
}
