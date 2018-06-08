package com.ex.dao;

import com.ex.entity.MusicManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicManageDao {

    public List<MusicManage> selectMusicManage();

    public int addMusicManage(MusicManage musicManage);
}
