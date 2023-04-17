package com.dormitory.service;

import com.dormitory.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> list();
    public List<Student> search(String key,String value);
    public void save(Student student);
    public void update(Student student,Integer oldDormitoryId);
    public void delete(Integer id,Integer dormitoryId);
    public List<Student> moveoutList();//获取可迁出的学生
    public List<Student> searchForMoveout(String key,String value);//搜索可迁出的学生
    public List<Student> findByDormitoryId(Integer dormitoryId);//学生缺寝登记展示里，需要根据宿舍来展示里面的学生
}
