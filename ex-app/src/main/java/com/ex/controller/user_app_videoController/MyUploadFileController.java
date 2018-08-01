package com.ex.controller.user_app_videoController;

import com.ex.entity.MyUploadFile;
import com.ex.service.MyUploadFileService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.FileEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/MyUploadFile")
public class MyUploadFileController {

    @Autowired
    private MyUploadFileService myUploadFileService;

    /**
     * 用户app上传文件
     * @param Files
     * @param registUserId
     * @param musicId
     * @param describe
     * @param link
     * @param request
     * @return
     */
    @RequestMapping("insertMyUploadFile")
    public JsonView insertMyUploadFile(MultipartFile[] Files,Long registUserId,Long musicId,String describe,String link,HttpServletRequest request) {
        JsonView jsonView = new JsonView();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        MyUploadFile myUploadFile = new MyUploadFile();
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try{
            if(Files!=null||Files.length>0){
                for (MultipartFile multipartFile:Files
                        ){
                    entity = fileUploadTool.createFile(multipartFile, request);
                    myUploadFile.setFileUrl(entity.getPath());
                }
            }if(registUserId!=null){
                myUploadFile.setRegistUserId(registUserId);
            }if(musicId!=null){
                myUploadFile.setMusicId(musicId);
            }if(describe!=null&&describe!=""){
                myUploadFile.setDescribe(describe);
            }if(link!=null&&link!=""){
                myUploadFile.setLink(link);
            }
            myUploadFile.setCreateTime(df.parse(df.format(new Date())));
            int i = myUploadFileService.insertMyUploadFile(myUploadFile);
            if(i>0){
                jsonView.setMessage("添加数据成功");
            }else {
                jsonView.setMessage("添加数据失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("上传失败");
        }
        return jsonView;
    }

    /**
     * 用户App-我享已发布效果
     * @param registUserId
     * @param page
     * @return
     */
    @RequestMapping("videoRelease")
    public JsonView videoRelease(Long registUserId,PageRequest page){
        JsonView jsonView = new JsonView();
        Map factorMap = new HashMap();
        try{
            if(registUserId!=null){
                factorMap.put("registUserId",registUserId);
            }
            PageInfo<MyUploadFile> myUploadFilePageInfo = myUploadFileService.selectListMyUploadFile(page, factorMap);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("返回数据成功");
            jsonView.setData(myUploadFilePageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }
}
