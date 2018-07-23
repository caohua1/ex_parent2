package com.ex.controller.user_app_controller.orderController;


import com.ex.entity.UserTransaction;
import com.ex.service.UserTransactionService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/transaction")
public class UserTransactionController {

    @Autowired
    private UserTransactionService userTransactionService;

    /**
     * 查询所有收入和支出
     * @param registUserId
     * @param page
     * @return
     */
    @RequestMapping("/selectUserTransactionAll")
    public JsonView selectUserTransactionAll(Long registUserId, PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageInfo<UserTransaction> pageInfo = userTransactionService.selectUserTransactionAll(registUserId, page);
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        }catch (Exception e){

        }
        return jsonView;
    }
}
