package package2;

import role.Member;
import java.util.ArrayList;

public interface MemberRepository {

    void save(Member member);

    ArrayList<Member> findAll();

    Member findByName(String targetName);

    boolean existsByName(String name);

}