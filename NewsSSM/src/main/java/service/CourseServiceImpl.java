package service;

import dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pojo.Course;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List qurryCourseMsgById(String id) {
        return courseDao.qurryCourseMsgById(id);
    }

    @Override
    public List<Course> querryAllCourse() {
        return courseDao.querryAllCourse();
    }

    @Override
    public int delCourse(int course_id) {
        return courseDao.delCourse(course_id);
    }

    @Override
    public int delCourseSel(int course_id) {
        return courseDao.delCourseSel(course_id);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }
}
