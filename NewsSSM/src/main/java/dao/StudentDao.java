package dao;

import pojo.Student;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
//    筛选所有学生
    public List<Student> queryAllStudent();
//    更新学生个人信息
    public int updateStudent(Student student);
//    学生登录
    public Student studentLogin(@Param("id") String stu_id,@Param("password") String password);
    //更新学生成绩
    public int updateScore(@Param("stu_id") int stu_id,@Param("score") String score,@Param("course_id") String course_id);
    //添加学生信息
    public int insertStudent(Student student);
    //删除学生信息
    public int delStudent(int stu_id);
}
