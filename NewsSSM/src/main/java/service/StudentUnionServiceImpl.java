package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.StudentUnionDao;
import pojo.StudentUnion;
import pojo.StudentUnion2;

import java.util.List;

@Service
public class StudentUnionServiceImpl implements StudentUnionService{
    @Autowired
    private StudentUnionDao studentUnionDao;

    @Override
    public List<StudentUnion2> qurryStudentByCourseId(String course_id) {
        return studentUnionDao.qurryStudentByCourseId(course_id);
    }

    @Override
    public List<StudentUnion> qurryStudentMsgByStuId(int stu_id) {
        return studentUnionDao.qurryStudentMsgByStuId(stu_id);
    }

    @Override
    public List<StudentUnion> qurryStudentMsg() {
        return studentUnionDao.qurryStudentMsg();
    }

    @Override
    public List<StudentUnion> searchStudentMsg(String major_id,String stu_id) {
        return studentUnionDao.searchStudentMsg(major_id,stu_id);
    }
}
