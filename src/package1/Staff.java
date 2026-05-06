package package1;

public class Staff extends Member {

    private String role;

    public Staff(String name, String major, int generation, String part, String role) {
        super(name, major, generation, part);
        this.role = role;
    }

    @Override
    public SubmitPolicy getSubmitPolicy() {
        return new StaffSubmitPolicy();
    }

    @Override
    public String getDetailInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", generation=" + generation +
                ", part='" + part + '\'' +
                '}';
    }
}
