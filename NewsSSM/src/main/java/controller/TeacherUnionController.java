package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeacherUnionService;
import service.TeacherUnionServiceImpl;

@Controller
public class TeacherUnionController {
    @Autowired
    TeacherUnionService teacherUnionService;
    @RequestMapping(value="teacLogin",method= RequestMethod.POST)
    @ResponseBody
    public String teacherLogin(String id,String password) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(id+"!!"+password);
        String teacherUnion=mapper.writeValueAsString(teacherUnionService.teacLogin(id,password));
        System.out.println(teacherUnion);
        return teacherUnion;
    }

    @RequestMapping(value="selTeac")
    @ResponseBody
    public String selTeac(String id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String teacherUnion=mapper.writeValueAsString(teacherUnionService.selTeacMsgById(id));
//        System.out.println(teacherUnion);
        return teacherUnion;
    }

    @RequestMapping(value="selAllTeac")
    @ResponseBody
    public String queryTeacMsg() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String teacherUnion=mapper.writeValueAsString(teacherUnionService.queryTeacMsg());
//        System.out.println(teacherUnion);
        return teacherUnion;
    }
    @RequestMapping("insertTeacher")
    @ResponseBody
    public String insertTeacher(String teac_name,String password,int dept_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(teacherUnionService.insertTeacher(teac_name,password,dept_id));
//        System.out.println(teacherUnion);
        return count;
    }

    @RequestMapping("delTeacher")
    @ResponseBody
    public String delTeacher(int teac_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(teacherUnionService.delTeacher(teac_id));
//        System.out.println(teacherUnion);
        return count;
    }
}
