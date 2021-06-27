package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MajorService;
import service.NoticeUnionService;

@Controller
public class NoticeUnionController {
    @Autowired
    private NoticeUnionService noticeUnionService;
    @RequestMapping("selAllNotice")
    @ResponseBody
    public String queryAllNotice() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(noticeUnionService.queryAllNotice());
        System.out.println(count);
        return count;
    }
    @RequestMapping("selAllNoticeByNoticeId")
    @ResponseBody
    public String selAllNoticeByNoticeId(String id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(noticeUnionService.queryAllNoticeByNoticeId(id));
        System.out.println(count);
        return count;
    }
    @RequestMapping("addNotice")
    @ResponseBody
    public String addNotice(String notice_content, String time) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(noticeUnionService.addNotice(notice_content,time));
//        String id=mapper.writeValueAsString(noticeUnionService.selNoticeId());
        return count;
    }
    @RequestMapping("insertSelect")
    @ResponseBody
    public String insertNoticeSelect(String idList)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String id=mapper.writeValueAsString(noticeUnionService.selNoticeId());
//        System.out.println(idList);
        String []arr=idList.split(",");
        for (String major_id : arr) {
//            System.out.println(Integer.parseInt(major_id));	// 输出
            mapper.writeValueAsString(noticeUnionService.insertNoticeSelect(Integer.parseInt(id),Integer.parseInt(major_id)));
        }
        return "a";
    }
    @RequestMapping("deleteNoticeById")
    @ResponseBody
    public String deleteNoticeById(int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count=mapper.writeValueAsString(noticeUnionService.deleteNoticeById(id));
        String count1=mapper.writeValueAsString(noticeUnionService.deleteNoticeSelectById(id));
        return count1;
    }
    @RequestMapping("queryAllNoticeByMajorId")
    @ResponseBody
    public String queryAllNoticeByMajorId(int major_id)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String count = mapper.writeValueAsString(noticeUnionService.queryAllNoticeByMajorId(major_id));
        return count;
    }
}
