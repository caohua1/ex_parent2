package com.ex.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.aliyuncs.exceptions.ClientException;
import com.ex.dao.AppointmentOrderDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.dao.UserAppInfoDao;
import com.ex.entity.AppointmentOrder;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.AppointmentOrder1Service;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.AppointmentOrderByUserAppVo;
import com.ex.vo.AppointmentOrderVo;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service(version = "1.1.0")
public class AppointmentOrder1ServiceImpl implements AppointmentOrder1Service {

    @Autowired
    private AppointmentOrderDao appointmentOrderDao;
    @Autowired
    private UserAppInfoDao userAppInfoDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private ProductPropertySetDao productPropertySetDao;

    /**
     * 预订，并支付
     * @param appointmentOrder
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder) {
        JsonView jsonView = new JsonView();
        //支付成功后，才能预订（支付失败不能添加预订信息到数据库）

        //预订成功添加到数据库
        Integer i = appointmentOrderDao.insertAppointmentOrder(appointmentOrder);
        if(i>0){
            jsonView.setMessage("预订成功");
            jsonView.setCode(JsonView.SUCCESS);
        }

        return jsonView;
    }

    /**
     * 查询选择的商品的价格
     * @param id
     * @return
     */
    @Override
    public double selectProductPrice(String ids) {
        double prices = 0;
        if(ids!=null && ids.length()>0){
            String[] split = ids.split(",");
            for(String id :split){
                //“——”左边是单价，右边是数量
                String[] split1 = id.split("_");
                //单价*数量
                prices += (appointmentOrderDao.selectProductPrice(Long.parseLong(split1[0])).getResalePrice())*Long.parseLong(split1[1]);
            }
        }
        return prices;
    }

    /**
     * 取消预约订单（用户取消3，商家取消4）
     * @param appointmentOrderVo
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout=36000)
    @Override
    public Boolean updateAppointmentOrder(AppointmentOrderVo appointmentOrderVo) throws ClientException {
        Integer i = appointmentOrderDao.updateAppointmentOrder(appointmentOrderVo);
        if(i>0 && (appointmentOrderVo.getStatus()==4 || appointmentOrderVo.getStatus()==3)){
            //取消订单后，退款,查询订单金额
            AppointmentOrderVo appointmentOrderVo1 = appointmentOrderDao.selectAppAppointmentById(appointmentOrderVo.getId());
            //退款给用户
            UserVo userVo = new UserVo();
            userVo.setRegistUserId(appointmentOrderVo1.getRegistUserId());
            userVo.setYuE(appointmentOrderVo1.getAppointmentMoney());
            userVo.setUpdateTime(new Date());
            Integer j = userAppInfoDao.updateUserAppInfo(userVo);
           /* if(j>0){
                //短信提醒
                UserVo user = userAppInfoDao.findByUserId(appointmentOrderVo1.getRegistUserId());
                String phone = user.getPhone(); //用户的电话
                String realName = user.getRealName(); //用户的真实姓名
                String content = String.valueOf(appointmentOrderVo1.getAppointmentMoney());
                SMSUtil.sendSMS(phone,content,realName,2);
            }*/
           return i>0 && j>0;
        }else{
            return false;
        }
    }

    /**
     * 查询预约订单下预约的所有商品信息
     * @param ProductInfoIds
     * @return
     */
    @Override
    public List<ProductInfoManage> selectProductsByIds(List ProductInfoIds) {
        return appointmentOrderDao.selectProductsByIds(ProductInfoIds);
    }

    /**
     * 根据用户Id查询该用户所有的预定信息
     * @param registUserId
     * @return
     */
    @Override
    public List<AppointmentOrderByUserAppVo> selectAppointmentOrderByUserApp(Long registUserId) {
        return appointmentOrderDao.selectAppointmentOrderByUserApp(registUserId);
    }

    //=====================================订单管理模块
    /**
     * 订单管理模块，查询所有的预约订单
     * @param appointmentOrderVo
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<AppointmentOrderVo> selectAppontmentOrdersByParam(AppointmentOrderVo appointmentOrderVo, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<AppointmentOrderVo> appointmentOrderVos = appointmentOrderDao.selectAppontmentOrdersByParam(appointmentOrderVo);
        PageInfo<AppointmentOrderVo> pageInfo = new PageInfo<>(appointmentOrderVos);
        pageInfo.setSize(appointmentOrderVos.size());
        return pageInfo;
    }

    /**
     * 查询预约订单详情
     * @param id
     * @return
     */
    @Override
    public AppointmentOrderVo selectAppAppointmentById(Long id) {
        AppointmentOrderVo appointmentOrderVo = appointmentOrderDao.selectAppAppointmentById(id);
        if(appointmentOrderVo!=null){
            /*String productInfoIds = appointmentOrderVo.getProductInfoIds();
            List<ProductInfoManage> productInfoManages = appointmentOrderDao.selectProductsByIds1(productInfoIds);
            appointmentOrderVo.setProductInfoManageList(productInfoManages);*/
            String[] split = appointmentOrderVo.getProductInfoIds().split(",");
            List list = new ArrayList();
            for(String s:split){
                list.add(Long.parseLong(s));
            }
            List<ProductInfoManage> productInfoManages = appointmentOrderDao.selectProductsByIds(list);
            appointmentOrderVo.setProductInfoManageList(productInfoManages);
        }
        return appointmentOrderVo;
    }


}
