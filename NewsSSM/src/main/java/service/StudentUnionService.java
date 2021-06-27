package service;

import pojo.StudentUnion;
import pojo.StudentUnion2;

import java.util.List;

public interface StudentUnionService {
    public List<StudentUnion> qurryStudentMsgByStuId(int stu_id);
    public List<StudentUnion2> qurryStudentByCourseId(String course_id);
    public List<StudentUnion> qurryStudentMsg();
    public List<StudentUnion> searchStudentMsg(String major_id,String stu_id);

}
