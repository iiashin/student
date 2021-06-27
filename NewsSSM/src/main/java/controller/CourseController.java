package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Course;
import service.CourseService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("selCourseByTeaId")
    @ResponseBody
    public String selCourseMsg(String id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String course=mapper.writeValueAsString(courseService.qurryCourseMsgById(id));
        return course;
    }
    @RequestMapping("selAllCourse")
    @ResponseBody
    public String querryAllCourse() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String course=mapper.writeValueAsString(courseService.querryAllCourse());
        return course;
    }
    @RequestMapping("addCourse")
    @ResponseBody
    public void addCourse(Course course, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String course1=mapper.writeValueAsString(courseService.addCourse(course));
        resp.sendRedirect("http://localhost:8080/teahome");
    }
    @RequestMapping("delCourse")
    @ResponseBody
    public String delCourse(int course_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String course=mapper.writeValueAsString(courseService.delCourse(course_id));
        String course1=mapper.writeValueAsString(courseService.delCourseSel(course_id));
        return course;
    }
}
