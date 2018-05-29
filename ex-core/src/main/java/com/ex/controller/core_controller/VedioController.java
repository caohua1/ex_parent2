package com.ex.controller.core_controller;

import javax.servlet.http.HttpServletRequest;

import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.vo.FileEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/file")
public class VedioController {
	
	@RequestMapping("tZhuan")
	public String tZhuan(){
		return "video";
	}


    @RequestMapping("upload")
    public JsonView upload(MultipartFile multipartFile,
                           HttpServletRequest request, ModelMap map) {
        String message = "";
        FileEntity entity = new FileEntity();
        JsonView jsonView = new JsonView();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if (entity != null) {
//        service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
                jsonView.setData(map);
            } else {
                message = "上传失败";
                map.put("result", message);
                jsonView.setData(map);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonView;
    }

}
