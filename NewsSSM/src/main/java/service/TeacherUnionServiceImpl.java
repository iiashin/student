package service;

import dao.TeacherUnionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pojo.TeacherUnion;

import java.util.List;

@Service
public class TeacherUnionServiceImpl implements TeacherUnionService {
    @Autowired
    private TeacherUnionDao teacherUnionDao;
    @Override
    public TeacherUnion teacLogin(String id, String password) {
        return teacherUnionDao.teacLogin(id,password);
    }
    @Override
    public TeacherUnion selTeacMsgById(String teac_id){
        return teacherUnionDao.selTeacMsgById(teac_id);
    }

    @Override
    public List<TeacherUnion> queryTeacMsg() {
        return teacherUnionDao.queryTeacMsg();
    }

    @Override
    public int insertTeacher(String teac_name, String password, int dept_id) {
        return teacherUnionDao.insertTeacher(teac_name,password,dept_id);
    }

    @Override
    public int delTeacher(int teac_id) {
        return teacherUnionDao.delTeacher(teac_id);
    }
}
