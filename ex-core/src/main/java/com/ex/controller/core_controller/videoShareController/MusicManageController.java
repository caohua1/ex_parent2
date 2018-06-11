package com.ex.controller.core_controller.videoShareController;


import com.ex.entity.MusicManage;
import com.ex.service.MusicManageService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.FileEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 音乐管理接口
 */
@RestController
@RequestMapping("/MusicManage")
public class MusicManageController {

    @Autowired
    private MusicManageService musicManageService;

    /**
     * 查询音乐列表全部数据
     * @param page
     * @return
     */
    @RequestMapping("selectMusicManage")
    public JsonView selectMusicManage(PageRequest page){
        JsonView jsonView= new JsonView();
        try{
            PageInfo<MusicManage> musicManagePageInfo = musicManageService.selectMusicManage(page);
            jsonView.success(musicManagePageInfo);
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }

    /**
     * 上传音乐文件和音乐图标
     * @param Files
     * @param request
     * @param map
     * @param musicName
     * @param singer
     * @return
     */
    @RequestMapping("addMusicManage")
    public JsonView addMusicManage(MultipartFile[] Files,
                                   HttpServletRequest request,
                                   ModelMap map,String musicName,String singer){
        MusicManage musicManage =new MusicManage();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String message = "";
        FileEntity entity = new FileEntity();
        JsonView jsonView = new JsonView();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try{
            for (MultipartFile multipartFile:Files
                    ) {
                entity = fileUploadTool.createFile(multipartFile, request);
                if (entity != null) {
                    System.out.println("返回报文---"+entity);
                    musicManage.setMusicName(musicName);
                    musicManage.setSinger(singer);
                    musicManage.setCreateTime(df.parse(df.format(new Date())));
                    musicManage.setMusicUrl(entity.getPath());
                    int i = musicManageService.addMusicManage(musicManage);
                    if(i>0){
                        message = "上传成功，并且路径已存入数据库中";
                        map.put("entity", entity);
                        map.put("result", message);
                        jsonView.setData(map);
                    }else {
                        message = "路径存入数据库失败";
                        map.put("result", message);
                        jsonView.setData(map);
                    }
                } else {
                    message = "上传失败";
                    map.put("result", message);
                    jsonView.setData(map);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonView;
    }

}
