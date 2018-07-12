package com.ex.controller;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.vo.FileEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {


    /**
     * ajxa提交
     * pc端，上传文件（上传多个）
     * @param Files
     * @param request
     * @return
     */
    @RequestMapping("files")
    public JsonView uploadFile(MultipartFile[] Files,HttpServletRequest request){
        JsonView jsonView = new JsonView();
        try{
            List<FileEntity> fileEntityList = new ArrayList<>();
            FileUploadTool fileUploadTool = new FileUploadTool();
            if(Files!=null||Files.length>0){
                //上传多个文件
                for (MultipartFile multipartFile:Files) {
                    FileEntity entity = fileUploadTool.createFile(multipartFile, request);//上传每个文件
                    fileEntityList.add(entity);
                }
                jsonView.setMessage("上传成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(fileEntityList);//上传的多个文件，返回文件的信息
            }else{
                jsonView.setMessage("没有选择文件");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("上传失败");
        }
        return jsonView;
    }
}
