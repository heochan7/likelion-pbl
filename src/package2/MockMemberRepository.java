package package2;


import role.Member;

import java.util.ArrayList;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {

    }

    @Override
    public ArrayList<Member> findAll() {
        return null;
    }

    @Override
    public Member findByName(String targetName) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
