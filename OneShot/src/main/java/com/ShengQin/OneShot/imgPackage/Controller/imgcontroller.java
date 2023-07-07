package com.ShengQin.OneShot.imgPackage.Controller;
import com.ShengQin.OneShot.imgPackage.Utils.uploadutilgame;
import com.ShengQin.OneShot.imgPackage.Utils.uploadutilshot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/img")
public class imgcontroller {
    //阿里云上传接口，获取通过返回的url

    //shot图片仓库
    @PostMapping("/upimgshot")
    public String upimgshot(MultipartHttpServletRequest multipartRequest) throws IOException {
//        int shotid = (int) requestBody.get("shotid");
        MultipartFile file = multipartRequest.getFile("file");
        uploadutilshot.uploadImageshot(file,4);
        System.out.println(file);
        return "success";
    }

    //比赛图片仓库
    @PostMapping("/upimgGame")
    public String upimgGame(MultipartFile file,int participate_id) throws IOException {
        return uploadutilgame.uploadImageGame(file,participate_id);
    }

}
