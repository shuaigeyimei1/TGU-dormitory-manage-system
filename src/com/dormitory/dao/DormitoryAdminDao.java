package com.dormitory.dao;

import com.dormitory.entity.DormitoryAdmin;

import java.util.List;

public interface DormitoryAdminDao {
    public List<DormitoryAdmin> list();
    public List<DormitoryAdmin> search(String key,String value);
    public Integer save(DormitoryAdmin dormitoryAdmin);
    public Integer update(DormitoryAdmin dormitoryAdmin);
    public Integer delete(Integer id);
    public DormitoryAdmin findByUsername(String username);//宿管登录，找是否有该人
}
