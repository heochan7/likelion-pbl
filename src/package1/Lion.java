package package1;

public class Lion {
    public String name;
    String major;
    private int num;

    public Lion(String name, String major, int num) {

        this.name = name;
        this.major = major;
        this.num = num;
    }

    public boolean validate(){
        System.out.println("검증 시작");
        if(name.equals("")) {
            System.out.println("이름은 비어 있을 수 없습니다.");
            return false;
        }
        else if(major.equals("")){
            System.out.println("전공은 비어 있을 수 없습니다.");
            return false;
        }
        else if(num < 1) {
            System.out.println("기수가 1 미만이다.");
            return false;
        }
        System.out.println("객체가 정상적으로 판단했습니다.");
        System.out.println(toString());
        return true;
    }


    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", num=" + num +
                '}';
    }
}
