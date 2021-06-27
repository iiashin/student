package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Book;
import pojo.StudentUnion;
import service.CourseServiceImpl;
import service.CourseUnionService;
import service.StudentUnionService;

import java.util.List;


@Controller
public class CourseUnionController {
    @Autowired
    private CourseUnionService courseUnionService;
    @Autowired
    private StudentUnionService studentUnionService;
    @RequestMapping("selCourseMsgByStuId")
    @ResponseBody   //不会走视图解析器,会直接返回一个字符串
    public String CourseMsgByStuId(int stu_id,int term ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String courseUnion = mapper.writeValueAsString(courseUnionService.qurryCourseMsgByStuId(stu_id,term));
        return courseUnion;
    }
    @RequestMapping("addSelectStu")
    @ResponseBody
    public String addSelectStu(String idList,int course_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String []arr=idList.split(",");
        for (String major_id : arr) {
            major_id="%"+major_id+"%";
            String stu_id="%%";
            List<StudentUnion> studentUnions = studentUnionService.searchStudentMsg(major_id,stu_id);
            for(int i=0;i<studentUnions.size();i++){
                String courseUnion;
                if((courseUnionService.selMsgByIds(studentUnions.get(i).getStu_id(),course_id)).size()==0)
                    courseUnion = mapper.writeValueAsString(courseUnionService.addSelect( studentUnions.get(i).getStu_id(),course_id));
            }
        }
        return  "2";
    }
    @RequestMapping("selMsgByIds")
    @ResponseBody
    public String selMsgByIds(int stu_id,int course_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(courseUnionService.selMsgByIds(stu_id,course_id));
        return "1";
    }

    @RequestMapping("delSelect")
    @ResponseBody
    public String delSelect(int stu_id,int course_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(courseUnionService.delSelect(stu_id,course_id));
        return "1";
    }
}
