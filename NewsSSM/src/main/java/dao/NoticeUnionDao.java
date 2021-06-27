package dao;

import org.apache.ibatis.annotations.Param;
import pojo.NoticeUnion;

import java.util.List;

public interface NoticeUnionDao {
    public List<NoticeUnion> queryAllNotice();
    public List<NoticeUnion> queryAllNoticeByNoticeId(String id);
    public int addNotice(@Param("notice_content") String notice_content,@Param("time") String time);
//    获取添加的通知序列号
    public int selNoticeId();
    //添加到notice_select表
    public int insertNoticeSelect(@Param("notice_id") int notice_id,@Param("major_id") int major_id);
    //删除通知
    public int deleteNoticeById(int id);
    //删除select通知
    public int deleteNoticeSelectById(int id);
    //根据学号查找通知
    public List<NoticeUnion> queryAllNoticeByMajorId(int major_id);
}
