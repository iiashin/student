package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeptService;
import service.MajorService;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("selDept")
    @ResponseBody
    public String queryDept() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(deptService.queryDept());
        System.out.println(count);
        return count;
    }
}
