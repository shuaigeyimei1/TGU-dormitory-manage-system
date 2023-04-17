package com.dormitory.dao;

import com.dormitory.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> list();
    public List<Student> search(String key,String value);
    public Integer save(Student student);
    public Integer update(Student student);
    public Integer delete(Integer id);
    public List<Integer> findStudentIdByDormitoryId(Integer id);//在删除宿舍时，要找到里面的学生来换宿舍
    public Integer updateDorimtory(Integer studentId,Integer dormitoryId);//删除宿舍时执行给里面的学生更换宿舍
    public List<Student> moveoutList();//获取可迁出的学生
    public List<Student> searchForMoveout(String key,String value);//搜索可迁出的学生
    public Integer updateStateById(Integer id);//学生迁出后修改学生状态
    public List<Student> findByDormitoryId(Integer id);//学生缺寝登记展示里，需要根据宿舍来展示里面的学生
}
