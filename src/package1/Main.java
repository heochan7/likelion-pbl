package package1;

import role.Lion;
import role.Member;
import role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 요구사항: Main에서는 Service만 생성해서 사용한다.
        MemberService service = new MemberService();

        while (true) {
            System.out.println("\n===== 멋사 멤버 관리 시스템  =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            // 숫자가 아닌 문자 입력 시 에러 방지 및 버퍼 비우기 최적화
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (menuChoice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menuChoice) {
                case 1:
                    // 1. 역할 선택
                    System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("숫자로 선택해주세요.");
                        scanner.nextLine();
                        break;
                    }
                    int roleChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n정보 입력");
                    System.out.print("이름: ");     String name = scanner.nextLine();
                    System.out.print("전공: ");     String major = scanner.nextLine();

                    System.out.print("기수: ");
                    int generation = 0;
                    if (scanner.hasNextInt()) {
                        generation = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                    }

                    System.out.print("파트: ");     String part = scanner.nextLine();

                    Member member;
                    if (roleChoice == 1) {
                        System.out.print("학번: "); int num = scanner.nextInt();
                        scanner.nextLine();
                        member = new Lion(name, major, generation, part, num);
                    } else {
                        System.out.print("직책: "); String sRole = scanner.nextLine();
                        member = new Staff(name, major, generation, part, sRole);
                    }

                    service.join(member);
                    break;

                case 2:
                    System.out.println("\n===== 전체 멤버 목록 =====");
                    // 서비스에서 전체 목록을 받아옴
                    List<Member> members = service.findAllMembers();

                    if (members == null || members.isEmpty()) {
                        System.out.println("등록된 멤버가 없습니다.");
                    } else {
                        for (Member m : members) {
                            // 각 맴버 정보를 예쁘게 출력 (Member 클래스에 toString()이 구현되어 있으면 편해)
                            System.out.println(m);
                        }
                    }
                    break;

                case 3:
                    System.out.print("검색할 이름: ");
                    String searchName = scanner.nextLine();

                    Member foundMember = service.findMemberByName(searchName);

                    if (foundMember == null) {
                        System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
                    } else {
                        System.out.println("\n===== 검색 결과 =====");
                        System.out.println(foundMember);
                    }
                    break;

                default:
                    System.out.println("잘못된 번호입니다. 1~4번 사이의 숫자를 입력해주세요.");
                    break;
            }
        }
    }
}