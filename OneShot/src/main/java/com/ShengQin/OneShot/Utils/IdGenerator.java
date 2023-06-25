package com.ShengQin.OneShot.Utils;

public class IdGenerator {
    private static int userId;
    private static int shotId;
    private static int postId;
    public synchronized static int newUserID(){
        userId++;
        return userId;//未完成
    }
    public synchronized static int newShotId(){
        shotId++;
        return shotId;
    }
    public synchronized static int newPostId(){
        postId++;
        return postId;
    }
}
