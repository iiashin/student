package pojo;

public class StudentUnion2 {
    private int stu_id;
    private String stu_name;
    private String score;
    private String dept_name;
    private String major_name;
    private String course_name;
    private int course_id;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    @Override
    public String toString() {
        return "StudentUnion2{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", score='" + score + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", major_name='" + major_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_id=" + course_id +
                '}';
    }
}
