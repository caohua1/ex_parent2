package com.ex.dao;

import com.ex.entity.MyUploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户App上传文件Dao层
 */
@Mapper
public interface MyUploadFileDao {

    public int insertMyUploadFile(MyUploadFile MyUploadFile);

    public List<MyUploadFile> selectListMyUploadFile(Map factorMap);

}
