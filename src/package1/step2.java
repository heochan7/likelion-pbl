package package1;

import java.util.Scanner;

public class step2 {
    public static void main(String[] args){
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

        System.out.println("객체를 생성합니다.");
        Lion lion = new Lion(name, major, num);
    }
}
