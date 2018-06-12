package com.ex.controller.merchant_pc_controller.productManageController;

import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.ProductService;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 分享设置
     * @param productInfoManage
     * @return
     */
    public JsonView shareSet(ProductInfoManage productInfoManage){
        JsonView jsonView = new JsonView();
        try{
            Integer i = productService.shareSet(productInfoManage);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("设置成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("分享设置失败");
        }
        return jsonView;
    }

    //查询所有商品
    //查看某商品的详情










}
