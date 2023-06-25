package com.ShengQin.OneShot.Entities;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Data
public class Shot {
    private int id;
    private int owner_id;//该shot属于谁
    private String title;
    private String content;
    private int total_thumb;
    private int total_collect;
    private DateTimeLiteralExpression.DateTime createTime;
    private int pageView;//；浏览量
    public void addThumb(){
        total_thumb++;
    }
    public void subThumb(){
        total_thumb--;
    }
    public void addCollect(){
        total_collect++;
    }
    public void subCollect(){
        total_collect--;
    }
    public void addPageView(){
        pageView++;
    }
}
