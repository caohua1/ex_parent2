package com.ex.controller.user_app_controller.orderController;


import com.ex.entity.UserTransaction;
import com.ex.service.UserTransactionService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/transaction")
public class UserTransactionController {

    @Autowired
    private UserTransactionService userTransactionService;

    /**
     * 按ID查询所有的收入信息
     *
     * @param registUserId
     * @param page
     * @return
     */
    @RequestMapping("/selectUserTransactionIncome")
    public JsonView selectUserTransactionIncome(Long registUserId, PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<UserTransaction> userTransactions = userTransactionService.selectUserTransactionIncome(registUserId);
            PageInfo<UserTransaction> pageInfo = new PageInfo<>(userTransactions);
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按ID查询所有的支出信息
     *
     * @param registUserId
     * @param page
     * @return
     */
    @RequestMapping("/selectUserTransactionDisburse")
    public JsonView selectUserTransactionDisburse(Long registUserId, PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<UserTransaction> userTransactions = userTransactionService.selectUserTransactionDisburse(registUserId);
            PageInfo<UserTransaction> pageInfo = new PageInfo<>(userTransactions);
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}
