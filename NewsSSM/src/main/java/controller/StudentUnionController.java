package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentUnionService;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentUnionController {
    @Autowired
    private StudentUnionService studentUnionService;
    @RequestMapping("/selStuMsgByStuId")
    @ResponseBody
    public String StudentMsgByStuId(int stu_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String studentUnion = mapper.writeValueAsString(studentUnionService.qurryStudentMsgByStuId(stu_id));
        System.out.println(studentUnion);
        return studentUnion;
    }

    @RequestMapping("/selStuMsgByCourseId")
    @ResponseBody
    public String qurryStudentByCourseId(String course_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String studentUnion2 = mapper.writeValueAsString(studentUnionService.qurryStudentByCourseId(course_id));
//        System.out.println(studentUnion);
        return studentUnion2;
    }

    @RequestMapping("/qurryStudentMsg")
    @ResponseBody
    public String qurryStudentMsg() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String studentUnion = mapper.writeValueAsString(studentUnionService.qurryStudentMsg());
        System.out.println(studentUnion);
        return studentUnion;
    }

    @RequestMapping("/searchStudentMsg")
    @ResponseBody
    public String searchStudentMsg(String major_id,String stu_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        major_id="%"+major_id+"%";
        stu_id="%"+stu_id+"%";
        String studentUnion = mapper.writeValueAsString(studentUnionService.searchStudentMsg(major_id,stu_id));

        return studentUnion;
    }
}
