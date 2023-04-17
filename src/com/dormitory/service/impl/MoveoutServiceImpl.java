package com.dormitory.service.impl;

import com.dormitory.dao.DormitoryDao;
import com.dormitory.dao.MoveoutDao;
import com.dormitory.dao.StudentDao;
import com.dormitory.dao.impl.DormitoryDaoImpl;
import com.dormitory.dao.impl.MoveoutDaoImpl;
import com.dormitory.dao.impl.StudentDaoImpl;
import com.dormitory.entity.Moveout;
import com.dormitory.service.MoveoutService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MoveoutServiceImpl implements MoveoutService {

    private MoveoutDao moveoutDao = new MoveoutDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();

    @Override
    public void save(Moveout moveout) {
        Integer updateStateById = this.studentDao.updateStateById(moveout.getStudentId());//修改学生状态为迁出
        Integer addAvailable = this.dormitoryDao.addAvailable(moveout.getDormitoryId());//宿舍人数增加1
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        moveout.setCreateDate(simpleDateFormat.format(date));
        Integer save = this.moveoutDao.save(moveout);
        if(save != 1 || updateStateById != 1 || addAvailable != 1) throw new RuntimeException("迁出学生失败");
    }

    @Override
    public List<Moveout> list() {
        return this.moveoutDao.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
        if(value.equals("")) return this.moveoutDao.list();
        return this.moveoutDao.search(key, value);
    }
}
