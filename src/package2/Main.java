package package2;

import role.Lion;
import role.Member;
import role.Staff;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1. 멤버 등록 | 2. 전체 멤버 | 3. 이름으로 검색 | 4. 파트별 조회 | 5. 종료");
            System.out.print("선택: ");
            choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerMember(sc, members);
                    break;
                case 2:
                    printAllMembers(members);
                    break;
                case 3:
                    searchMember(sc, members);
                    break;
                case 4:
                    searchPart(sc, members);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        } while (choice != 5);
    }

    // 1. 멤버 등록 로직
    private static void registerMember(Scanner sc, List<Member> members) {
        System.out.print("역할 선택 (아기사자: 1, 운영진: 2): ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("이름: "); String name = sc.nextLine();
        boolean isDuplicate = members.stream()
                .anyMatch(m -> m.getName().equals(name));

        if (isDuplicate) {
            System.out.println("이미 등록된 이름입니다. 등록을 취소합니다.");
            return; // 메서드 종료
        }

        System.out.print("전공: "); String major = sc.nextLine();
        System.out.print("기수: "); int gen = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("파트: "); String part = sc.nextLine();

        if (type == 1) {
            System.out.print("학번: "); int num = sc.nextInt();
            sc.nextLine();
            members.add(new Lion(name, major, gen, part, num));
        } else {
            System.out.print("직책: "); String sRole = sc.nextLine();
            members.add(new Staff(name, major, gen, part, sRole));
        }
        System.out.println("등록 완료!");
    }

    // 2. 전체 멤버 출력 로직
    private static void printAllMembers(List<Member> members) {
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        System.out.println("\n=== 전체 멤버 목록 ===");
        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            System.out.printf("%d. [%s] %s (%d기)\n", i + 1, m.getRole(), m.getName(), m.getGeneration());
        }
    }

    // 3. 이름 검색 로직
    private static void searchMember(Scanner sc, List<Member> members) {
        System.out.print("검색할 이름: ");
        String targetName = sc.nextLine();

        // 스트림을 이용해 조건에 맞는 첫 번째 멤버 찾기
        members.stream()
                .filter(m -> m.getName().equals(targetName))
                .findFirst()
                .ifPresentOrElse(
                        member -> {
                            System.out.println("\n[검색 결과]");
                            System.out.println(member.getDetailInfo());
                            member.checkSubmission(); // 과제 제출 대상 여부 출력
                        },
                        () -> System.out.println("존재하는 멤버가 없습니다.")
                );
    }

    private static void searchPart(Scanner sc, List<Member> members){
        if(members.isEmpty()){
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        Map<String, List<Member>> membersByPart = members.stream()
                .collect(Collectors.groupingBy(Member::getPart));

        Set<String> parts = membersByPart.keySet();
        String joinedParts = String.join(" ", parts);
        System.out.println("등록된 파트: [ " + joinedParts + " ]");

        System.out.print("조회할 파트 : ");
        String search =sc.nextLine();
        // 검색하고 싶은 파트명
        List<Member> memberList = membersByPart.get(search);
        for (int i = 0; i < memberList.size(); i++) {
            Member member = memberList.get(i); // 변수에 담기
            System.out.printf("%d. %s(%s) - %d기%n",
                    i + 1,
                    member.getName(),
                    member.getRole(),
                    member.getGeneration()
            );
        }
    }
}

