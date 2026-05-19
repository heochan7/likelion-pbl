package package1;

import role.Member;
import java.util.ArrayList;

public class MemberRepository {

    private final ArrayList<Member> members;

    public MemberRepository() {
        this.members = new ArrayList<>();
    }

    public void save(Member member) {
        members.add(member);
    }

    public ArrayList<Member> findAll() {
        return members;
    }

    public Member findByName(String targetName) {
        return members.stream()
                .filter(m -> m.getName().equals(targetName))
                .findFirst()
                .orElse(null); // 못 찾으면 null 반환 (Service에서 예외 처리하도록)
    }

    // 4. 이름 중복 확인 기능
    public boolean existsByName(String name) {
        return members.stream()
                .anyMatch(m -> m.getName().equals(name));
    }


}