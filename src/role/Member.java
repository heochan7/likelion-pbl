package role;

import policy.SubmitPolicy;

public abstract class Member {
    protected String name;
    protected String major;
    protected int generation;
    protected String part;
    protected String role;

    public Member(String name, String major, int generation, String part, String role) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getRole() {
        return role;
    }

    public abstract SubmitPolicy getSubmitPolicy();
    public abstract String getDetailInfo();

    public void checkSubmission(){
        if(getSubmitPolicy().canSubmit()){
            System.out.println("과제 제출 가능");
        }else {
            System.out.println("과제 제출 대상 아님");
        }
    }



}
