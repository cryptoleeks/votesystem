/*
 * @(#)PicServer.java 2019年1月10日下午5:30:23
 * ssm
 * Copyright 2019 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package blog.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.JsonObject;

import blog.dao.Blog;
import core.ajaxResult.AjaxResult;
import core.exception.MyException;
import core.utils.StringUtil;
import core.utils.SystemUtil;

/**
 * PicServer
 * @author lenovo
 * @version 1.0
 */
@Controller
@RequestMapping("/picture")
public class PicServer {
    
    @ResponseBody
    @RequestMapping(value="/test")
    public String test(){
       return "ok";
    }
    
    @RequestMapping(value = "/save")
    @ResponseBody
    public Object uploadAuthImages(@RequestParam(value = "file", required = false) MultipartFile files, 
                HttpServletRequest request) {
            Map<String, Object> map = new HashMap<String, Object>();
            //保存文件  
           // for(int i=0; i<files.length; i++){
            String INTERNET_IP=SystemUtil.INTERNET_IP;//获取外网ip
            String path = request.getContextPath();//项目路径
          
                String filePath = request.getSession().getServletContext().getRealPath("/")  + "upload/";
                UUID uuid = UUID.randomUUID();
                String fileName = new Date().getTime() + uuid.toString() + ".jpg";
                System.out.println("图片地址："+filePath);
                File targetFile = new File(filePath, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                // 保存
                try {
                    files.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //添加图片路径到map集合http://localhost:8080/ssm/upload/15472639306217846b116-568c-4e72-b398-38f2eb7804b9.jpg
                map.put("img", "http://172.23.22.154:8080"+path+"/upload/" + fileName);
              String jsonString = JSONUtils.toJSONString(map);
               
          //  }
           /* map.put("photo4", request.getParameter("photo4"));
            map.put("photo5", request.getParameter("photo5"));*/
            return jsonString;

        }

}
