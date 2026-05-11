package role;

import policy.LionSubmitPolicy;
import policy.SubmitPolicy;

public class Lion extends Member {
    private int num;
    public Lion(String name, String major, int generation, String part, int num) {
        super(name, major, generation, part, "LION");
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public SubmitPolicy getSubmitPolicy() {
        return new LionSubmitPolicy();
    }

    @Override
    public String toString() {
        return "Lion{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", generation=" + generation +
                ", part='" + part + '\'' +
                '}';
    }

    @Override
    public String getDetailInfo() {
        return toString();
    }
}
