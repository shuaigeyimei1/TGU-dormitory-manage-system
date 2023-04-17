package com.dormitory.dao;

import com.dormitory.entity.Dormitory;

import java.util.List;

public interface DormitoryDao {
    public List<Dormitory> list();
    public List<Dormitory> search(String key,String value);
    public List<Dormitory> availableList();
    public Integer subAvailable(Integer id);
    public Integer addAvailable(Integer id);
    public List<Integer> findDormitoryIdByBuildingId(Integer id);//在删除楼宇时，找到里面的宿舍
    public Integer availableId();//在删除宿舍时，给里面学生更换宿舍，找到一个可住人的宿舍
    public Integer deleteById(Integer id);//删除宿舍
    public Integer save(Dormitory dormitory);
    public Integer update(Dormitory dormitory);
    public List<Dormitory> findByBuildingId(Integer id);//学生缺寝登记展示里，需要根据楼来展示里面的宿舍
}
