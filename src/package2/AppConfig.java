package package2;

public class AppConfig {
    private int mode;

    // 생성자를 통해 모드를 결정 (예: "memory" 또는 "mock")
    public AppConfig(int mode) {
        this.mode = mode;
    }

    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    private MemberRepository memberRepository() {
        if (mode == 1) {
            return new MemoryMemberRepository(); // 기본값
        }
        return new MockMemberRepository();
    }
}