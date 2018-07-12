package com.ex.controller.user_app_videoController;

import com.ex.entity.ReportVideo;
import com.ex.service.ReportVideoService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.vo.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 视频举报
 */
@RestController
@RequestMapping("/ReportVideo")
public class ReportVideoController {

    @Autowired
    private ReportVideoService reportVideoService;

    /**
     * 添加举报视频数据
     * @param Files
     * @param uploadFileId
     * @param registUserId
     * @param causeBy
     * @param describe
     * @param request
     * @return
     */
    @RequestMapping("insertReportVideo")
    public JsonView insertReportVideo(MultipartFile[] Files,Long uploadFileId,Long registUserId, String causeBy, String describe,HttpServletRequest request){
        JsonView jsonView = new JsonView();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        ReportVideo reportVideo = new ReportVideo();
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try{
            if(Files!=null||Files.length>0){
                for (MultipartFile multipartFile:Files
                        ){
                    entity = fileUploadTool.createFile(multipartFile, request);
                    reportVideo.setPicUrl(entity.getPath());
                }
            }if(uploadFileId!=null){
                reportVideo.setUploadFileId(uploadFileId);
            }if(registUserId!=null){
                reportVideo.setRegistUserId(registUserId);
            }if(causeBy!=null&&causeBy!=""){
                reportVideo.setCauseBy(causeBy);
            }if(describe!=null&&describe!=""){
                reportVideo.setDescribe(describe);
            }
            reportVideo.setCreateTime(df.parse(df.format(new Date())));
            int i = reportVideoService.insertReportVideo(reportVideo);
            if(i>0){
                jsonView.setMessage("添加数据成功");
            }else {
                jsonView.setMessage("添加数据失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("举报失败");
        }
        return jsonView;
    }
}
