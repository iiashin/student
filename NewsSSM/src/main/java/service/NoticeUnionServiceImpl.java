package service;

import dao.NoticeUnionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NoticeUnion;

import java.util.List;

@Service
public class NoticeUnionServiceImpl implements NoticeUnionService {
    @Autowired
    private NoticeUnionDao noticeUnion;
    @Override
    public List<NoticeUnion> queryAllNotice() {
        return noticeUnion.queryAllNotice();
    }

    @Override
    public List<NoticeUnion> queryAllNoticeByNoticeId(String id) {
        return noticeUnion.queryAllNoticeByNoticeId(id);
    }

    @Override
    public int addNotice(String notice_content, String time) {
        return noticeUnion.addNotice(notice_content,time);
    }

    @Override
    public int selNoticeId() {
        return noticeUnion.selNoticeId();
    }

    @Override
    public int insertNoticeSelect(int notice_id, int major_id) {
        return noticeUnion.insertNoticeSelect(notice_id,major_id);
    }

    @Override
    public int deleteNoticeById(int id) {
        return noticeUnion.deleteNoticeById(id);
    }

    @Override
    public int deleteNoticeSelectById(int id) {
        return noticeUnion.deleteNoticeSelectById(id);
    }

    @Override
    public List<NoticeUnion> queryAllNoticeByMajorId(int major_id){
        return noticeUnion.queryAllNoticeByMajorId(major_id);
    }
}
