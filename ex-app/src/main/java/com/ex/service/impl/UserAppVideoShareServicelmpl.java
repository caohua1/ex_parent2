package com.ex.service.impl;


import com.ex.dao.MyUploadFileDao;
import com.ex.dao.UserAppVideoShareDao;
import com.ex.entity.MyUploadFile;
import com.ex.service.UserAppVideoShareService;
import com.ex.vo.UserAppVideoShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserAppVideoShareServicelmpl implements UserAppVideoShareService {

    @Autowired
    private UserAppVideoShareDao userAppVideoShareDao;

    @Autowired
    private MyUploadFileDao myUploadFileDao;

    /**
     * 用户app视享
     * @param contMap
     * @return
     */
    @Override
    public List<UserAppVideoShare> selectUserAppVideoShare(Map contMap) {
        return userAppVideoShareDao.selectUserAppVideoShare(contMap);
    }

    /**
     * 修改商户点赞次数
     * @param contMap
     * @return
     */
    @Override
    public int updateUserAppVideoShare(Map contMap) {
        return userAppVideoShareDao.updateUserAppVideoShare(contMap);
    }

    /**
     * 查询用户上传所有数据
     * @param typeMap
     * @return
     */
    @Override
    public List<MyUploadFile> selectMyUpload(Map typeMap) {
        return myUploadFileDao.selectMyUpload(typeMap);
    }

    /**
     * 修改用户点赞次数
     * @param contMap
     * @return
     */
    @Override
    public int updateLikeCont(Map contMap) {
        return myUploadFileDao.updateLikeCont(contMap);
    }


}
