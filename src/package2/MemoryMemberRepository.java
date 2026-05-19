package package2;

import role.Member;

import java.util.ArrayList;

public class MemoryMemberRepository implements MemberRepository {

    private final ArrayList<Member> members = new ArrayList<>() ;

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public ArrayList<Member> findAll() {
        return members;
    }

    @Override
    public Member findByName(String targetName) {
        return members.stream()
                .filter(m -> m.getName().equals(targetName))
                .findFirst()
                .orElse(null); // 못 찾으면 null 반환 (Service에서 예외 처리하도록)
    }

    public boolean existsByName(String name) {
        return members.stream()
                .anyMatch(m -> m.getName().equals(name));
    }
}
