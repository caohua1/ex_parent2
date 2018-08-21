package com.ex.controller.user_app_videoController;

import com.ex.entity.MyUploadFile;
import com.ex.service.CareService;
import com.ex.service.UserAppVideoShareService;
import com.ex.util.JsonView;
import com.ex.vo.UserAppVideoShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/VideoShareController")
public class VideoShareController {

    @Autowired
    private UserAppVideoShareService userAppVideoShareService;
    @Autowired
    private CareService careService;

    /**
     * 用户app视享
     * @param fileType
     * @return
     */
    @RequestMapping("selectUserAppVideoShare")
    public JsonView selectUserAppVideoShare(int fileType){
        JsonView jsonView = new JsonView();
        try{
        Map contMap = new HashMap();
            Map DateMap=new HashMap();
        contMap.put("fileType",fileType);
        List<UserAppVideoShare> userAppVideoShares = userAppVideoShareService.selectUserAppVideoShare(contMap);
        List<MyUploadFile> myUploadFiles = userAppVideoShareService.selectMyUpload(contMap);
            if(userAppVideoShares!=null||myUploadFiles!=null){
                DateMap.put("userAppVideoShares",userAppVideoShares);
                DateMap.put("myUploadFiles",myUploadFiles);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("返回数据成功");
            jsonView.setData(DateMap);
        }else{
            jsonView.setMessage("暂无数据");
            jsonView.setCode(JsonView.SUCCESS);
        }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }

    /**
     * 增加视频点赞次数
     * @param id
     * @param
     * @return
     */
    @RequestMapping("updateDZNum")
    public JsonView updateDZNum(Long id,int type){
        JsonView jsonView = new JsonView();
        Map contMap = new HashMap();
        try{
            if(id!=null&type==2){
                contMap.put("id",id);
                contMap.put("DZNum",1);
                int i = userAppVideoShareService.updateUserAppVideoShare(contMap);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("点赞成功");
                }else {
                    jsonView.setMessage("点赞失败");
                }
            }else if(id!=null&type==1){
                contMap.put("id",id);
                contMap.put("DZNum",1);
                int i = userAppVideoShareService.updateLikeCont(contMap);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("点赞成功");
                }else {
                    jsonView.setMessage("点赞失败");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("失败");
        }
        return jsonView;
    }

    /**
     * 添加关注数据
     * @param careUserId
     * @param beCareUserId
     * @param type
     * @return
     */
    @RequestMapping("insertCare")
    public JsonView insertCare(Long careUserId,Long beCareUserId,Integer type){
        JsonView jsonView = new JsonView();
        HashMap demandMap = new HashMap();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try{
            if(careUserId!=null){
                demandMap.put("careUserId",careUserId);
            }if(beCareUserId!=null){
                demandMap.put("beCareUserId",beCareUserId);
            }if(type!=null){
                demandMap.put("type",type);
            }
            demandMap.put("createTime",df.parse(df.format(new Date())));
            demandMap.put("status",1);
            int i = careService.insertCare(demandMap);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("关注成功");
            }else {
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("关注失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("失败");
        }
        return jsonView;
    }

    /**
     * 用户取消关注
     * @param careUserId
     * @param beCareUserId
     * @param type
     * @return
     */
    @RequestMapping("unfollow")
    public JsonView unfollow(Long careUserId,Long beCareUserId,Integer type){
        JsonView jsonView = new JsonView();
        HashMap demandMap = new HashMap();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try{
            if(careUserId!=null){
                demandMap.put("careUserId",careUserId);
            }if(beCareUserId!=null){
                demandMap.put("beCareUserId",beCareUserId);
            }if(type!=null){
                demandMap.put("type",type);
            }
            demandMap.put("updateTime",df.parse(df.format(new Date())));
            demandMap.put("status",0);
            int i = careService.updateCare(demandMap);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("修改成功");
            }else {
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("失败");
        }
        return jsonView;
    }










    public static void qiXi() throws ParseException, InterruptedException {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();// new Date()为获取当前系统时间
        for (int i=1; i<=i+1; i++){
            Thread.sleep(1000);
                long between=(new Date().getTime()-date.getTime())/1000;//除以1000是为了转换成秒
                long second1=between;
                if(second1==1){
                    System.out.println("有时打动我的是一首歌，");
                }else if(second1==2){
                    System.out.println("因为唱出了我的感觉，");
                }else if(second1==3){
                    System.out.println("有时打动我的是一篇文，");
                }else if(second1==4){
                    System.out.println("因为写出了我的心声，");
                }else if(second1==5){
                    System.out.println("有时打动我的是一条微信，");
                }else if(second1==6){
                    System.out.println("只因为发送者是你，");
                }else if(second1==7){
                    System.out.println("七夕将至，我更想你..");
                }else if(second1==8){
                    date=new Date();
                }
            }
        }
    public static void main(String[] args){
        try {
            try {
                qiXi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    }

