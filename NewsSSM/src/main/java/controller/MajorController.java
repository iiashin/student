package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MajorService;

@Controller
public class MajorController {
    @Autowired
    private MajorService majorService;
    @RequestMapping("selMajor")
    @ResponseBody
    public String queryMajor() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(majorService.queryMajor());
        System.out.println(count);
        return count;
    }
}
