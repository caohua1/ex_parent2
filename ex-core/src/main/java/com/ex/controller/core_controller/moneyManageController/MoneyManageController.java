package com.ex.controller.core_controller.moneyManageController;
import com.ex.entity.MerchantPersonData;
import com.ex.entity.MerchantTransaction;
import com.ex.entity.UserTransaction;
import com.ex.service.MerchantPersonDataService;
import com.ex.service.UserService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantMoneyVo;
import com.ex.vo.UserMoneyVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/moneyManage")
@RestController
public class MoneyManageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MerchantPersonDataService merchantPersonDataService;


    //用户资金账户管理
    /**
     * 用户资金账户管理
     * @param minMoney
     * @param maxMoney
     * @param username
     * @return
     */
    @RequestMapping("/selectUserMoneyByParam")
    public JsonView selectUserMoneyByParam(Double minMoney, Double maxMoney, String username, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(minMoney!=null){
                map.put("minMoney",minMoney);
            }
            if(maxMoney!=null){
                map.put("maxMoney",maxMoney);
            }
            if(username!=null && !("").equals(username)){
                map.put("username",username);
            }
            PageInfo<UserMoneyVo> pageInfo = userService.selectUserMoneyByParam(map, pageRequest);
            Map map1 = new HashMap();
            map1.put("pageInfo",pageInfo);
            map1.put("count",pageInfo.getSize());//总数
            if(pageInfo!=null && pageInfo.getList().size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(map1);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    //查询用户的账户明细
    /**
     * 查询用户的账户明细(条件筛选)
     * @param SZType (收入=1，支出=0)
     * @param registUserId
     * @param type （0提现 1充值 2下单  3分享，得到的佣金 4退款）
     * @return
     */
    @RequestMapping("/selectUserTransaction")
    public JsonView selectUserTransaction(Integer SZType,Long registUserId,Integer type,PageRequest pageRequest){
       JsonView jsonView = new JsonView();
       try{
           Map map = new HashMap();
           if(SZType!=null){
               map.put("SZType",SZType);
           }
           if(registUserId!=null){
               map.put("registUserId",registUserId);
           }
           if(type!=null){
               map.put("type",type);
           }
           PageInfo<UserTransaction> pageInfo = userService.selectUserTransaction(map, pageRequest);
           Map map1 = new HashMap();
           map1.put("pageInfo",pageInfo);
           map1.put("count",pageInfo.getSize());//总数
           if(pageInfo!=null && pageInfo.getList().size()>0){
               jsonView.setMessage("查询成功");
               jsonView.setCode(JsonView.SUCCESS);
               jsonView.setData(map1);
           }else{
               jsonView.setCode(JsonView.ERROR);
               jsonView.setMessage("暂无数据");
           }
       }catch(Exception e){
           e.printStackTrace();
           jsonView.setMessage("查询异常");
       }
        return jsonView;
    }

    //商家账户管理
    /**
     * 商家资金账户管理
     * @param minMoney
     * @param maxMoney
     * @param username
     * @return
     */
    @RequestMapping("/selectMerchantMoneyByParam")
    public JsonView selectMerchantMoneyByParam(Double minMoney, Double maxMoney, String username, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(minMoney!=null){
                map.put("minMoney",minMoney);
            }
            if(maxMoney!=null){
                map.put("maxMoney",maxMoney);
            }
            if(username!=null && !("").equals(username)){
                map.put("username",username);
            }
            PageInfo<MerchantMoneyVo> pageInfo = merchantPersonDataService.selectMerchantYuE(map, pageRequest);
            Map map1 = new HashMap();
            map1.put("pageInfo",pageInfo);
            map1.put("count",pageInfo.getSize());//总数
            if(pageInfo!=null && pageInfo.getList().size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(map1);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    //商家账户明细
    /**
     * 查询商家的账户明细(条件筛选)
     * @param SZType (收入=1，支出=0)
     * @param merchantId
     * @param type （0提现 1充值 2分享分享推荐，得到的佣金 3分享入住权限，得到的佣金）
     * @return
     */
    @RequestMapping("/selectUserTransaction")
    public JsonView selectMerchantTransaction(Integer SZType,Long merchantId,Integer type,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(SZType!=null){
                map.put("SZType",SZType);
            }
            if(merchantId!=null){
                map.put("merchantId",merchantId);
            }
            if(type!=null){
                map.put("type",type);
            }
            PageInfo<MerchantTransaction> pageInfo = merchantPersonDataService.selectMerchantTransaction(map, pageRequest);
            Map map1 = new HashMap();
            map1.put("pageInfo",pageInfo);
            map1.put("count",pageInfo.getSize());//总数
            if(pageInfo!=null && pageInfo.getList().size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(map1);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

}
