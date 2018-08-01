package com.ex.controller.core_controller.advertisingManageController;

import com.ex.entity.IndexAdvertising;
import com.ex.service.IndexAdvertisingService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("indexAdvertising")
public class IndexAdvertisingController {

    @Autowired
    private IndexAdvertisingService indexAdvertisingService;

    /**
     * 添加首页广告
     * @param indexAdvertising (type（0 .banner图 1.弹框图 2.首页广告（2的分享））)
     * @return
     */
    @RequestMapping("/insertAdvertising")
    public JsonView insertAdvertising(IndexAdvertising indexAdvertising){
        JsonView jsonView = new JsonView();
        try{
            indexAdvertising.setCreateTime(new Date());
            Integer i = indexAdvertisingService.insertAdvertising(indexAdvertising);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("添加成功");
            }else{
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("添加异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 分页查询广告信息
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAdvertising")
    public JsonView selectAdvertising(IndexAdvertising indexAdvertising,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(indexAdvertising!=null && indexAdvertising.getType()!=null){
                map.put("type",indexAdvertising.getType());
            }
            PageInfo<IndexAdvertising> pageInfo = indexAdvertisingService.selectAdvertising(map,pageRequest);
            Integer count = indexAdvertisingService.selectAdvertisingCount(map);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(count);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 查询广告详情
     * @param id
     * @return
     */
    @RequestMapping("/selectAdvertisingById")
    public JsonView selectAdvertisingById(Long id){
        JsonView jsonView = new JsonView();
        try{
            IndexAdvertising indexAdvertising = indexAdvertisingService.selectAdvertisingById(id);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(indexAdvertising);
            jsonView.setMessage("查询成功");
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 编辑广告
     * @param indexAdvertising
     * @return
     */
    @RequestMapping("/updateAdvertising")
    public JsonView updateAdvertising(IndexAdvertising indexAdvertising){
        JsonView jsonView = new JsonView();
        try{
            indexAdvertising.setUpdateTime(new Date());
            Integer i = indexAdvertisingService.updateAdvertising(indexAdvertising);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("编辑成功");
            }else{
                jsonView.setMessage("编辑失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("编辑异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }
}
