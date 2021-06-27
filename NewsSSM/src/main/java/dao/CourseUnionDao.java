package dao;

import pojo.Book;
import pojo.CourseUnion;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseUnionDao {
//    根据学号和学期筛选课程
    public List<CourseUnion> qurryCourseMsgByStuId(@Param("stu_id") int stu_id,@Param("term") int term);
    //添加选课信息
    public int addSelect(@Param("stu_id") int stu_id,@Param("course_id") int course_id);
    //根据学号，课程号筛选是否选中课程
    public List<CourseUnion> selMsgByIds(@Param("stu_id") int stu_id,@Param("course_id") int course_id);
    //根据学号，课程号删除表内容
    public int delSelect(@Param("stu_id") int stu_id,@Param("course_id") int course_id);
}
