package package1;

public abstract class Member {
    protected String name;
    protected String major;
    protected int generation;
    protected String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
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
