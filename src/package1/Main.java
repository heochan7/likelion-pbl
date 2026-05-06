package package1;

import java.util.Scanner;

public class Main {

    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 아기사자 정보 입력 ===");
        System.out.print("이름: "); String lName = sc.nextLine();
        System.out.print("전공: "); String lMajor = sc.nextLine();
        System.out.print("기수: "); int lOrdinal = sc.nextInt(); sc.nextLine();
        System.out.print("파트: "); String lPart = sc.nextLine();
        System.out.print("학번: "); int num = sc.nextInt();

        Member lion = new Lion(lName, lMajor, lOrdinal, lPart, num);

        sc.nextLine();
        // 2. 운영진 정보 입력
        System.out.println("\n=== 운영진 정보 입력 ===");
        System.out.print("이름: "); String sName = sc.nextLine();
        System.out.print("전공: "); String sMajor = sc.nextLine();
        System.out.print("기수: "); int sOrdinal = sc.nextInt(); sc.nextLine();
        System.out.print("파트: "); String sPart = sc.nextLine();
        System.out.print("직책: "); String sRole = sc.nextLine();

        Member staff = new Staff(sName, sMajor, sOrdinal, sPart, sRole);

        System.out.println("아기사자 출력 결과");;
        System.out.println(lion.getDetailInfo());
        lion.checkSubmission();

        System.out.println("운영진 출력 결과");;
        System.out.println(staff.getDetailInfo());
        staff.checkSubmission();
    }
}
