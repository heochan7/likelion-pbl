package package2;

import package1.Lion;

public class step3 {
    public static void main(String[] args){
        Lion lion = new Lion("홍길동", "컴퓨터공학과", 14);
        System.out.println(lion.toString());

        System.out.println("public 접근");
        lion.name = "홍길삼";
        System.out.println(lion.toString());

//        System.out.println("default 접근");
//        lion.major = "전기공학과";
//
//        System.out.println("private 접근");
//        lion.num = 13;

    }
}
