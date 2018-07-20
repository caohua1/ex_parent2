package com.ex.controller.core_controller.userManageController;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserService;
import com.ex.util.CustomMD5;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userManage")
public class UserManageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户
     * @param page
     * @return
     */
    @RequestMapping("/all")
    public JsonView findAll(PageRequest page,UserAppRegist userAppRegist,Date startTime,Date endTime) {
        logger.info("Request comming to find user list...");
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(userAppRegist!=null){
                if(userAppRegist.getUsername()!=null && !("").equals(userAppRegist.getUsername())){
                    map.put("username",userAppRegist.getUsername());
                }
            }
            if(startTime!=null){
                map.put("startTime",startTime);
            }
            if(endTime!=null){
                map.put("endTime",endTime);
            }
            PageInfo<UserAppRegist> pageInfo = userService.findAll(map,page);
            Integer userCount = userService.findUserCount(map);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setTodoCount(userCount);
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }

        return jsonView;
    }

    /**
     * 根据用户id查询用户的详情
     * @param id
     * @return
     */
    @RequestMapping("/findByUserId")
    public JsonView findByUserId(Long id){
        JsonView jsonView = new JsonView();
        try{
            UserVo userVo = userService.findByUserId(id);
            if(userVo!=null){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(userVo);
            }else{
                jsonView.setMessage("暂无此用户的信息");
            }

        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    /**
     * 后台修改用户密码，注销账号
     * @param userAppRegist （id,password新密码,username或者 id,status = 2注销）
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public JsonView updateUserInfo(UserAppRegist userAppRegist){
        JsonView jsonView = new JsonView();
        try{
            userAppRegist.setUpdatetime(new Date());
            if(userAppRegist.getPassword()!=null && !("").equals(userAppRegist.getPassword()) && userAppRegist.getUsername()!=null && !("").equals(userAppRegist.getUsername())){
                userAppRegist.setPassword(CustomMD5.passwordAndSalt(userAppRegist.getPassword(),userAppRegist.getUsername()));
            }
            Integer i = userService.updateUserInfo(userAppRegist);
            if(i>0){
                if(userAppRegist.getPassword()!=null){
                    jsonView.setMessage("修改密码成功");
                }else if(userAppRegist.getStatus()!=null){
                    jsonView.setMessage("注销成功");
                }
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                if(userAppRegist.getPassword()!=null){
                    jsonView.setMessage("修改密码失败");
                }else if(userAppRegist.getStatus()!=null){
                    jsonView.setMessage("注销失败");
                }
                jsonView.setCode(JsonView.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("修改异常");
        }
        return jsonView;
    }

}
