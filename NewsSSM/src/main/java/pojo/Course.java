package pojo;

public class Course {
    private int course_id;
    private String course_name;
    private int classtime;
    private int term;
    private int day;
    private int teac_id;
    private String room;
    private int credit;
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getClasstime() {
        return classtime;
    }

    public void setClasstime(int classtime) {
        this.classtime = classtime;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(int teac_id) {
        this.teac_id = teac_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", classtime=" + classtime +
                ", term=" + term +
                ", day=" + day +
                ", teac_id=" + teac_id +
                ", room='" + room + '\'' +
                ", credit=" + credit +
                '}';
    }
}
