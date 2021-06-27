package dao;

import org.apache.ibatis.annotations.Param;
import pojo.StudentUnion;
import pojo.StudentUnion2;

import java.util.List;

public interface StudentUnionDao {
    //根据学号筛选学生信息
    public List<StudentUnion> qurryStudentMsgByStuId(int stu_id);
    //根据课程号筛选学生
    public List<StudentUnion2> qurryStudentByCourseId(String course_id);
    //筛选所有学生信息
    public List<StudentUnion> qurryStudentMsg();
    //根据信息筛选
    public List<StudentUnion> searchStudentMsg(@Param("major_id") String major_id,@Param("stu_id") String stu_id);
}
