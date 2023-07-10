package com.ShengQin.OneShot.imgPackage.Controller;
import com.ShengQin.OneShot.imgPackage.Utils.uploadutilgame;
import com.ShengQin.OneShot.imgPackage.Utils.Uploadutilshot;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;


@RestController
@RequestMapping("/img")
public class imgcontroller {
    //阿里云上传接口，获取通过返回的url

    //shot图片仓库
    @PostMapping("/upimgshot/{shot_id}")
    public String upimgshot(MultipartHttpServletRequest multipartRequest, @PathVariable("shot_id")int shot_id) throws IOException {
        System.out.println(shot_id);
        MultipartFile file = multipartRequest.getFile("file");
        Uploadutilshot.uploadImageshot(file,shot_id);
        System.out.println(file);
        return "success";
    }

    //比赛图片仓库
    @PostMapping("/upimgGame")
    public String upimgGame(MultipartHttpServletRequest multipartRequest, @PathVariable("participate_id")int participate_id) throws IOException {
        MultipartFile file = multipartRequest.getFile("file");
        return uploadutilgame.uploadImageGame(file,participate_id);
    }

}
