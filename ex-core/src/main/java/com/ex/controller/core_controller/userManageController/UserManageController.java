package com.ex.controller.core_controller.userManageController;
import com.ex.entity.UserAppRegist;
import com.ex.service.UserService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonView findAll(PageRequest page) {
        logger.info("Request comming to find user list...");
        JsonView jsonView = new JsonView();
        try{
            PageInfo<UserAppRegist> pageInfo = userService.findAll(page);
            Integer userCount = userService.findUserCount();
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

    //

}
