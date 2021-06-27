package service;

import org.apache.ibatis.annotations.Param;
import pojo.CourseUnion;

import java.util.List;

public interface CourseUnionService {
    public List<CourseUnion> qurryCourseMsgByStuId(int stu_id,int term);
    public int addSelect( int stu_id,int course_id);
    public List<CourseUnion> selMsgByIds(int stu_id,int course_id);
    public int delSelect(int stu_id,int course_id);

}
