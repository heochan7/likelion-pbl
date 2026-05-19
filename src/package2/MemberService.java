package package2;

import role.Member;

import java.util.ArrayList;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        if(!memberRepository.existsByName(member.getName())){
            memberRepository.save(member);
        }
    }

    public ArrayList<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Member findMemberByName(String name){
        return memberRepository.findByName(name);
    }

}