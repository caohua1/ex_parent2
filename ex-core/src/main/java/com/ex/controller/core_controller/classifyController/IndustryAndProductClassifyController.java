package com.ex.controller.core_controller.classifyController;

import com.ex.entity.Brand;
import com.ex.entity.IndustryClassify;
import com.ex.entity.ProductClassify;
import com.ex.service.BrandService;
import com.ex.service.IndustryClassifyService;
import com.ex.service.ProductClassifyService;
import com.ex.service.ProductService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/classify")
public class IndustryAndProductClassifyController {

    @Autowired
    private IndustryClassifyService industryClassifyService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductClassifyService productClassifyService;
    @Autowired
    private ProductService productService;

    //==============================行业分类管理

    /**
     * 添加行业分类
     * @param industryClassify
     * @return
     */
    @RequestMapping("/insertIndustry")
    public JsonView insertIndustry(IndustryClassify industryClassify){
        JsonView jsonView = new JsonView();
        try{
            industryClassify.setCreateTime(new Date());
            Integer i = industryClassifyService.insertIndustry(industryClassify);
            if(i>0){
                jsonView.setMessage("添加成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("添加异常失败");
        }
        return jsonView;
    }

    /**
     * 分页查询行业分类
     * @param industryClassify
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectIndustry")
    public JsonView selectIndustry(IndustryClassify industryClassify, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<IndustryClassify> pageInfo = industryClassifyService.selectIndustry(industryClassify, pageRequest);
            Integer count = industryClassifyService.selectIndustryCount(industryClassify);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setTodoCount(count);
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 修改行业分类（是否显示）
     * @param industryClassify
     * @return
     */
    @RequestMapping("/updateIndustry")
    public JsonView updateIndustry(IndustryClassify industryClassify){
        JsonView jsonView = new JsonView();
        try{
            industryClassify.setUpdateTime(new Date());
            Integer i = industryClassifyService.updateIndustry(industryClassify);
            if(i>0){
                jsonView.setMessage("修改成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("修改异常");
        }
        return jsonView;
    }

    /**
     * 删除行业分类
     * @param id
     * @return
     */
    @RequestMapping("/deleteIndsutry")
    public JsonView deleteIndsutry(Long id){
        JsonView jsonView = new JsonView();
        try{
            Integer i = industryClassifyService.deleteIndustry(id);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("删除成功");
            }else{
                jsonView.setMessage("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("删除异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    //=============================品牌管理

    /**
     * 添加品牌分类
     * @param brand
     * @return
     */
    @RequestMapping("/insertBrand")
    public JsonView insertBrand(Brand brand){
        JsonView jsonView = new JsonView();
        try{
            brand.setCreateTime(new Date());
            Integer i = brandService.insertBrand(brand);
            if(i>0){
                jsonView.setMessage("添加成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("添加品牌异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 分页查询品牌
     * @param brand
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectBrand")
    public JsonView selectBrand(Brand brand,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<Brand> pageInfo = brandService.selectBrands(brand, pageRequest);
            Integer count = brandService.selectBrandsCount(brand);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setTodoCount(count);
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @RequestMapping("/updateBrand")
    public JsonView updateBrand(Brand brand){
        JsonView jsonView = new JsonView();
        try{
            brand.setUpdateTime(new Date());
            Integer i = brandService.updateBrand(brand);
            if(i>0){
                jsonView.setMessage("修改成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("修改异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @RequestMapping("/deleteBrand")
    public JsonView deleteBrand(Long id){
        JsonView jsonView = new JsonView();
        try{
            Integer i = brandService.deleteBrand(id);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("删除成功");
            }else{
                jsonView.setMessage("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("删除异常");
        }
        return jsonView;
    }


    //================================商品分类管理


    /**
     * 添加商品分类，页面下拉菜单显示
     * @param model
     * @return
     */
    @RequestMapping("/toInsertProductClassify")
    public String XLCDProductClassify(Model model){
        List<ProductClassify> productClassifies = productService.selectProductClassify(null);
        model.addAttribute("productClassifies",productClassifies);
        return "";
    }

    /**
     * 添加商品分类
     * @param productClassify
     * @return
     */
    @RequestMapping("/insertProductClassify")
    public JsonView insertProductClassify(ProductClassify productClassify){
        JsonView jsonView = new JsonView();
        try{
            productClassify.setCreateTime(new Date());
            Integer i = productClassifyService.insertProductClassify(productClassify);
            if(i>0){
                jsonView.setMessage("添加成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("添加异常");
        }
        return jsonView;
    }

    /**
     * 分页查询所有的商品分类,查看下一级（levelNum/parentId）
     * @param productClassify（所有级别的商品/一级/二级/三级（levelNum/parentId））
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(ProductClassify productClassify,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ProductClassify> productClassifyPageInfo = productClassifyService.selectProductClassify(productClassify, pageRequest);
            Integer count = productClassifyService.selectProductClassifyCount(productClassify);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(productClassifyPageInfo);
            jsonView.setTodoCount(count);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return  jsonView;
    }

    /**
     * 修改商品分类
     * @param productClassify
     * @return
     */
    @RequestMapping("/updateProductClassify")
    public JsonView updateProductClassify(ProductClassify productClassify){
        JsonView jsonView = new JsonView();
        try{
            productClassify.setUpdateTime(new Date());
            Integer i = productClassifyService.updateProductClassify(productClassify);
            if(i>0){
                jsonView.setMessage("修改成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("修改异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    @RequestMapping("/deleteProductClassify")
    public JsonView deleteProductClassify(Long id){
        JsonView jsonView = new JsonView();
        try{
            Integer i = productClassifyService.deleteProductClassify(id);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("删除成功");
            }else{
                jsonView.setMessage("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("删除异常");
        }
        return jsonView;
    }
}
