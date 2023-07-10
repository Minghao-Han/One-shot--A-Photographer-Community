package com.ShengQin.OneShot.imgPackage.Utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Uploadutilshot {
    //阿里域名
    public static final String ALI_DOMAIN="https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/";

    public static String uploadImageshot(MultipartFile file,int shotid) throws IOException {
        //生成文件名

        String originFileName=file.getOriginalFilename();//原有文件名
        String ext="."+ FilenameUtils. getExtension(originFileName);//得到后缀,后续可以从后往前查
        //生成新的文件名，后期应该为用户的id

         String shotid1=Integer.toString(shotid);

       // String uuid= UUID.randomUUID().toString().replace("-","");

        //新文件名
        //String filename=id1+ext;
        String filename=shotid1+ext;

        //String filename =uuid+ext;

        //地域节点
        String endpoint = "http://oss-cn-guangzhou.aliyuncs.com";
        String accessKeyId = "LTAI5t7FB5WrLj8tzXHavT3p";
        String accessKeySecret = "pSPx3KU5dJfdQkhPKfnO5ZExyzYoe8";
        //OSS客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(
                "oneshot-test",//仓库名
                filename, //文件名
                file.getInputStream()
        );

        //String shot="shot/";
        ossClient.shutdown(); //关闭
        return ALI_DOMAIN+filename;
    }
}
