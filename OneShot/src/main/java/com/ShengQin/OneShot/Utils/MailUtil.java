package com.ShengQin.OneShot.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    private String defaultSender = "3508627758@qq.com";

    public boolean sendEmailCode(String captcha, String from, String to,String mailTile) {
        try {
            // 用来设置邮件信息
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // 设置邮件标题
            simpleMailMessage.setSubject(mailTile);
            // 设置邮件内容
            simpleMailMessage.setText("您收到的验证码是\n" + captcha+"\n请在三分钟内完成验证");
            // 设置源邮箱
            simpleMailMessage.setFrom(from);
            // 设置目的邮箱
            simpleMailMessage.setTo(to);
            // 发送
            javaMailSender.send(simpleMailMessage);
            // 没有出现异常，正常发送，返回true
            return true;
        } catch (MailException e) {
            // 发送过程中，发生错误，打印错误信息，返回false
            e.printStackTrace();
            return false;
        }
    }
    public boolean sendEmailCodeWithDefaultSender(String captcha, String to,String mailTile){
        return sendEmailCode(captcha,defaultSender,to,mailTile);
    }
}
