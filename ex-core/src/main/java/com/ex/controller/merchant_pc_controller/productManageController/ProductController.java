package com.ex.controller.merchant_pc_controller.productManageController;

import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.ProductService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//商品管理模块(pc端的接口)
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 选择商品分类（根据级别（一级/二级/三级））
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(){
        JsonView jsonView = new JsonView();
        try{
            ProductClassify productClassify = new ProductClassify();
            productClassify.setLevelNum(1);
            List<ProductClassify> productClassifies = productService.selectProductClassify(productClassify);
            if(productClassifies!=null){
                jsonView.setMessage("返回数据成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productClassifies);
            }else{
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("返回数据失败");
        }
        return jsonView;
    }


    /**
     * 添加商品（批量添加商品规格）
     * @param productInfoManage
     * @param list
     * @return
     */
    @RequestMapping("/insertProduct")
    public JsonView  InsertProduct(ProductInfoManage productInfoManage, List<ProductPropertySet> list){
        JsonView jsonView = new JsonView();
        try{
            Boolean b = productService.insertProduct(productInfoManage, list);
            if(b==true){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("添加成功");
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("添加失败");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    /**
     * 修改商品详情（分享设置）
     * @param productInfoManage
     * @return
     */
    @RequestMapping("/updateProductInfo")
    public JsonView updateProductInfo(ProductInfoManage productInfoManage,@RequestParam(required=false) List<ProductPropertySet> productPropertySetList){
        JsonView jsonView = new JsonView();
        try{
            productInfoManage.setUpdateTime(new Date());
            Boolean b = productService.updateProductInfo(productInfoManage,productPropertySetList);
            if(b==true){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("修改成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("修改失败");
        }
        return jsonView;
    }

    //

    /**
     * 分页查询所有商品(条件查询：商品名称，状态)
     * @param productInfoManageVo
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectProductInfos")
    public JsonView selectProductInfos(ProductInfoManageVo productInfoManageVo, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ProductInfoManageVo> productInfoManagePageInfo = productService.selectProductInfos(productInfoManageVo, pageRequest);
            Integer count = productService.selectCount(productInfoManageVo);
            if(productInfoManagePageInfo!=null && productInfoManagePageInfo.getSize()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(productInfoManagePageInfo);
                jsonView.setTodoCount(count);//总数量
            }else{
                jsonView.setMessage("暂无数据");
                jsonView.setCode(JsonView.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }


    //查看某商品的详情

    /**
     * 查询商品的详情
     * @param id
     * @return
     */
    @RequestMapping("/selectProductInfoById")
    public JsonView selectProductInfoById(Long id){
        JsonView jsonView = new JsonView();
        try{
            ProductInfoManageVo productInfoManageVo = productService.selectProductInfoById(id);
            if(productInfoManageVo!=null){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询诗句成功");
                jsonView.setData(productInfoManageVo);
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









}
