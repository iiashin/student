package pojo;

public class User {
    private String name;
    private String password;
    private int is_role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIs_role() {
        return is_role;
    }

    public void setIs_role(int is_role) {
        this.is_role = is_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", is_role=" + is_role +
                '}';
    }
}
