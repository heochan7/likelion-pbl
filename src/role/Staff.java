package role;

import policy.StaffSubmitPolicy;
import policy.SubmitPolicy;

public class Staff extends Member {

    private String sRole;

    public Staff(String name, String major, int generation, String part, String sRole) {
        super(name, major, generation, part, "STAFF");
        this.sRole = sRole;
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
                "role='" + sRole + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", generation=" + generation +
                ", part='" + part + '\'' +
                '}';
    }
}
