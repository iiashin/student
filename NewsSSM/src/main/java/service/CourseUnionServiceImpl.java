package service;

import dao.CourseDao;
import dao.CourseUnionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pojo.CourseUnion;

import java.util.List;

@Service
public class CourseUnionServiceImpl implements CourseUnionService {
    @Autowired
    private CourseUnionDao courseUnionDao;
    @Override
    public List<CourseUnion> qurryCourseMsgByStuId(int stu_id,int term) {
        return courseUnionDao.qurryCourseMsgByStuId(stu_id,term);
    }

    @Override
    public int addSelect(int stu_id, int course_id) {
        return courseUnionDao.addSelect(stu_id,course_id);
    }

    @Override
    public int delSelect(int stu_id, int course_id) {
        return courseUnionDao.delSelect(stu_id,course_id);
    }

    @Override
    public List<CourseUnion> selMsgByIds(int stu_id, int course_id) {
        return courseUnionDao.selMsgByIds(stu_id,course_id);
    }
}
