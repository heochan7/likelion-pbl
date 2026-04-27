package package1;

import java.util.Scanner;

public class step1 {

    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);

        String name;
        String major;
        int num;

        System.out.println("이름을 입력해주세요");
        name = sc.nextLine();

        System.out.println("전공을 입력해주세요");
        major = sc.nextLine();

        System.out.println("기수를 입력해주세요");
        num = sc.nextInt();

        System.out.println("검증 시작");
        if(name.equals("")) System.out.println("이름은 비어 있을 수 없습니다.");
        else if(major.equals("")) System.out.println("전공은 비어 있을 수 없습니다.");
        else if(num < 1) System.out.println("기수가 1 미만이다.");
        else {
            System.out.println("검증 통과");

            Lion lion = new Lion(name, major, num);
            System.out.println("객체 생성 ");
            System.out.println("정보 출력");
            System.out.println(lion.toString());
        }

    }
}
