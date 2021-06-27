package pojo;

public class NoticeUnion {
    private int notice_id;
    private String notice_content;
    private String time;
    private int major_id;
    private String  major_name;

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    @Override
    public String toString() {
        return "NoticeUnion{" +
                "notice_id=" + notice_id +
                ", notice_content='" + notice_content + '\'' +
                ", time='" + time + '\'' +
                ", major_id=" + major_id +
                ", major_name='" + major_name + '\'' +
                '}';
    }
}
