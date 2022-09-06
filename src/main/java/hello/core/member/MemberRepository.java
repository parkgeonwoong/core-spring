/**
 * @desc    : 회원 저장소 인터페이스
 * @author  : 박건웅
 */

package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
