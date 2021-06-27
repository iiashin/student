package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }
    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student studentLogin(String id, String password) {
        return studentDao.studentLogin(id,password);
    }

    @Override
    public int updateScore(int stu_id,String score,String course_id) {
        return studentDao.updateScore(stu_id,score,course_id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int delStudent(int stu_id) {
        return studentDao.delStudent(stu_id);
    }
}
