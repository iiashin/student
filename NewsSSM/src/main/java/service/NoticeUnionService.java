package service;

import dao.NoticeUnionDao;
import org.apache.ibatis.annotations.Param;
import pojo.NoticeUnion;

import java.util.List;

public interface NoticeUnionService {
    public List<NoticeUnion> queryAllNotice();
    public List<NoticeUnion> queryAllNoticeByNoticeId(String id);
    public int addNotice(String notice_content, String time);
    public int selNoticeId();
    public int insertNoticeSelect(int notice_id,int major_id);
    public int deleteNoticeById(int id);
    public int deleteNoticeSelectById(int id);
    public List<NoticeUnion> queryAllNoticeByMajorId(int major_id);
}
