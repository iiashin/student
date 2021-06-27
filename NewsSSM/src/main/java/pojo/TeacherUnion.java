package pojo;

public class TeacherUnion {
    private int teac_id;
    private String teac_name;
    private int dept_id;
    private String password;
    private String dept_name;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(int teac_id) {
        this.teac_id = teac_id;
    }

    public String getTeac_name() {
        return teac_name;
    }

    public void setTeac_name(String teac_name) {
        this.teac_name = teac_name;
    }

    @Override
    public String toString() {
        return "TeacherUnion{" +
                "teac_id=" + teac_id +
                ", teac_name='" + teac_name + '\'' +
                ", dept_id=" + dept_id +
                ", password='" + password + '\'' +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
