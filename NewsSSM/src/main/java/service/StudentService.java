package service;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> queryAllStudent();
    public int updateStudent(Student student);
    public Student studentLogin(String id,String password);
    public int updateScore(int stu_id,String score,String course_id);
    public int insertStudent(Student student);
    public int delStudent(int stu_id);
}
