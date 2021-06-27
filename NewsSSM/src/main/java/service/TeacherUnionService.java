package service;

import org.apache.ibatis.annotations.Param;
import pojo.TeacherUnion;

import java.util.List;

public interface TeacherUnionService {
    public TeacherUnion teacLogin(String id,String password);
    public TeacherUnion selTeacMsgById(String teac_id);
    public List<TeacherUnion> queryTeacMsg();
    public int insertTeacher(String teac_name,String password,int dept_id);
    public int delTeacher(int teac_id);
}
