package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Student;
import pojo.TeacherUnion;

import java.util.List;

public interface TeacherUnionDao {
    //    教师登录
    public TeacherUnion teacLogin(@Param("id") String teac_id, @Param("password") String password);
    //获取教师信息
    public TeacherUnion selTeacMsgById(String teac_id);
    //获取全部教师信息
    public List<TeacherUnion> queryTeacMsg();
    //添加教师
    public int insertTeacher(@Param("teac_name") String teac_name,@Param("password")String password,@Param("dept_id")int dept_id);
    //删除教师
    public int delTeacher(int teac_id);

}
