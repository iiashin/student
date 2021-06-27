package pojo;

public class StudentUnion {
    private int stu_id;
    private String stu_name;
    private String password;
    private int stu_dept;
    private int stu_major;
    private String sex;
    private String phone;
    private String guarder;
    private String guarder_phone;
    private String major_name;
    private String dept_name;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStu_dept() {
        return stu_dept;
    }

    public void setStu_dept(int stu_dept) {
        this.stu_dept = stu_dept;
    }

    public int getStu_major() {
        return stu_major;
    }

    public void setStu_major(int stu_major) {
        this.stu_major = stu_major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGuarder() {
        return guarder;
    }

    public void setGuarder(String guarder) {
        this.guarder = guarder;
    }

    public String getGuarder_phone() {
        return guarder_phone;
    }

    public void setGuarder_phone(String guarder_phone) {
        this.guarder_phone = guarder_phone;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "StudentUnion{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", password='" + password + '\'' +
                ", stu_dept=" + stu_dept +
                ", stu_major=" + stu_major +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", guarder='" + guarder + '\'' +
                ", guarder_phone='" + guarder_phone + '\'' +
                ", major_name='" + major_name + '\'' +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
