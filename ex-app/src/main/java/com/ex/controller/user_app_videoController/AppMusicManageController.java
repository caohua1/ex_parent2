package com.ex.controller.user_app_videoController;

import com.ex.entity.MusicManage;
import com.ex.service.MyUploadFileService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AppMusicManage")
public class AppMusicManageController {

    @Autowired
    private MyUploadFileService myUploadFileService;

    /**
     * 选择背景音乐接口
     * @return
     */
    @RequestMapping("selectMusicManage")
    public JsonView selectMusicManage(PageRequest page){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<MusicManage> musicManagePageInfo = myUploadFileService.selectMusicManage(page);
            if(musicManagePageInfo!=null){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("返回数据成功");
                jsonView.setData(musicManagePageInfo);
            }else {
                jsonView.setMessage("返回数据为空");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("访问异常");
        }
        return jsonView;
    }

}
