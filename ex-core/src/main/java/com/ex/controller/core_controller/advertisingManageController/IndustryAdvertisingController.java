package com.ex.controller.core_controller.advertisingManageController;
import com.ex.entity.IndustryAdvertising;
import com.ex.service.IndustryAdvertisingService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.IndustryAdvertisingVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/industryAdvertising")
public class IndustryAdvertisingController {

    @Autowired
    private IndustryAdvertisingService industryAdvertisingService;

    /**
     * 添加行业分类广告
     * @param industryAdvertising
     * @return
     */
    @RequestMapping("/insertAdvertising")
    public JsonView insertAdvertising(IndustryAdvertising industryAdvertising){
        JsonView jsonView = new JsonView();
        try{
            industryAdvertising.setCreateTime(new Date());
            Integer i = industryAdvertisingService.insertIndustryAdvertising(industryAdvertising);
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
     * 分页查询行业分类广告信息
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAdvertising")
    public JsonView selectAdvertising(PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<IndustryAdvertisingVo> pageInfo = industryAdvertisingService.selectIndustryAdvertising(pageRequest);
            Integer count = industryAdvertisingService.selectIndustryAdvertisingCount();
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
     * 查询行业分类广告详情
     * @param id
     * @return
     */
    @RequestMapping("/selectAdvertisingById")
    public JsonView selectAdvertisingById(Long id){
        JsonView jsonView = new JsonView();
        try{
            IndustryAdvertisingVo industryAdvertising = industryAdvertisingService.selectIndustryAdvertisingById(id);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(industryAdvertising);
            jsonView.setMessage("查询成功");
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 编辑行业分类广告
     * @param industryAdvertising
     * @return
     */
    @RequestMapping("/updateAdvertising")
    public JsonView updateAdvertising(IndustryAdvertising industryAdvertising){
        JsonView jsonView = new JsonView();
        try{
            industryAdvertising.setUpdateTime(new Date());
            Integer i = industryAdvertisingService.updateIndustryAdvertising(industryAdvertising);
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
