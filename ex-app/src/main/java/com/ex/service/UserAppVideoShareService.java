package com.ex.service;


import com.ex.vo.UserAppVideoShare;

import java.util.List;
import java.util.Map;

public interface UserAppVideoShareService {

    public List<UserAppVideoShare> selectUserAppVideoShare(Map contMap);

    public int updateUserAppVideoShare(Map contMap);
}
