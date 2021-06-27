package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Student;
import service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
//    筛选所有学生
    @RequestMapping("selAllStu")
    @ResponseBody   //不会走视图解析器,会直接返回一个字符串
    public String selAllUser() throws JsonProcessingException {
        // jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String students = mapper.writeValueAsString(studentService.queryAllStudent());
//        System.out.println(students);
        return students;
    }
//    更新学生信息
    @RequestMapping("updateStu")
    @ResponseBody
    public void upStudent(Student student, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(studentService.updateStudent(student));
        System.out.println(count);
        resp.sendRedirect("http://localhost:8080/stumsg");
    }

//    学生登录
    @RequestMapping(value="stuLogin",method= RequestMethod.POST)
    @ResponseBody
    public String studentLogin(String id, String password) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result=mapper.writeValueAsString(studentService.studentLogin(id,password));
        if(result.length()>0)
            return result;
        else
            return "0";
    }

    //更新成绩信息
    @RequestMapping(value="updatescore")
    @ResponseBody
    public String updateScore(int stu_id,String score,String course_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result=mapper.writeValueAsString(studentService.updateScore(stu_id,score,course_id));
        System.out.println(result);
        if(result.length()>0)
            return result;
        else
            return "0";
    }
    @RequestMapping("insertStudent")
    @ResponseBody
    public void insertStudent(Student student, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(studentService.insertStudent(student));
        System.out.println(count);
        resp.sendRedirect("http://localhost:8080/admin");
    }
    @RequestMapping("delStudent")
    @ResponseBody
    public String delStudent(int stu_id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(studentService.delStudent(stu_id));
        System.out.println(count);
        return count;
    }
}
