package dao;

import pojo.Course;
import pojo.CourseUnion;

import java.util.List;

public interface CourseDao {
    public List qurryCourseMsgById(String id);
    public List<Course> querryAllCourse();
    public int addCourse(Course course);
    public int delCourse(int course_id);
    public int delCourseSel(int course_id);
}
