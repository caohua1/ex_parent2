package com.ex.controller.core_controller;

import javax.servlet.http.HttpServletRequest;

import com.ex.util.FileUploadTool;
import com.ex.vo.FileEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/uploadflv")
public class VedioController {
	
	@RequestMapping("tZhuan")
	public String tZhuan(){
		return "video";
	}
	
	@RequestMapping("upload")
    @ResponseBody
    public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
                               HttpServletRequest request, ModelMap map) {
        System.out.println("进入");
		String message = "";
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if (entity != null) {
//        service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
            } else {
                message = "上传失败";
                map.put("result", message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("result", map);
    }
}
