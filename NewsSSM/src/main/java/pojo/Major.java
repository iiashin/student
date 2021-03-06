package pojo;

public class Major {
    int major_id;
    String major_name;

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
        return "Major{" +
                "major_id=" + major_id +
                ", major_name='" + major_name + '\'' +
                '}';
    }
}
