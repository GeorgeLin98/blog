package com.george.blog.controller;

import com.george.blog.pojo.ResultVO;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.MsgCodeDesc;
import com.george.blog.util.QiniuUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @description 文件上传controller
 * @author georgeLin
 * @date 2022-02-25-23:57
 */
public class UploadController {
    @Autowired
    private QiniuUtil qiniuUtil;
    /**
     * @description 上传文件
     * @date 2022.02.26
     * @author linzhuangze
     * @param file
     * @return
     */
    @PostMapping
    public ResultVO upload(@RequestParam("image") MultipartFile file){
        String fileName = UUID.randomUUID().toString() + ConstantUtil.STRING_POINT +
                StringUtils.substringAfterLast(file.getOriginalFilename(), ConstantUtil.STRING_POINT);
        boolean upload = qiniuUtil.upload(file, fileName);
        if (upload){
            return ResultVO.success(QiniuUtil.url + fileName);
        }
        return ResultVO.fail(MsgCodeDesc.UPLOAD_FAIL.getCode(),MsgCodeDesc.UPLOAD_FAIL.getMsg());
    }
}
