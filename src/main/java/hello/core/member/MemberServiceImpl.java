/**
 * @desc    : 회원 서비스 구현체
 * @author  : 박건웅
 */

package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스에만 의존하는 중
    private final MemberRepository memberRepository;

    // 생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
