package package1;

import role.Member;

import java.util.ArrayList;

public class MemberService {
    private final MemberRepository repository = new MemberRepository();

    public void join(Member member) {
        if(!repository.existsByName(member.getName())){
            repository.save(member);
        }
    }

    public ArrayList<Member> findAllMembers(){
        return repository.findAll();
    }

    public Member findMemberByName(String name){
        return repository.findByName(name);
    }

}