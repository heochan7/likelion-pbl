package package2;

import role.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class MockMemberRepository implements MemberRepository {

    // 1. 멀티스레드 환경에서도 안전한 동시성 컬렉션 사용
    private final List<Member> store = new CopyOnWriteArrayList<>();

    @Override
    public void save(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("저장할 회원 정보가 null입니다.");
        }
        store.add(member);
    }

    @Override
    public ArrayList<Member> findAll() {
        // 2. 반환 타입(ArrayList) 호환성을 맞추면서 외부 조작으로부터 데이터를 보호
        return new ArrayList<>(store);
    }

    @Override
    public Member findByName(String targetName) {
        if (targetName == null) return null;

        // 3. Stream API를 활용한 깔끔하고 최적화된 검색
        return store.stream()
                .filter(member -> targetName.equals(member.getName())) // member에 getName() 메서드가 있다고 가정
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean existsByName(String name) {
        if (name == null) return false;

        return store.stream()
                .anyMatch(member -> name.equals(member.getName()));
    }

    // 4. 테스트 편의성을 위한 초기화 메서드 (선택 사항)
    public void clearStore() {
        store.clear();
    }
}