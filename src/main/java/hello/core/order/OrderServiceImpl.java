package hello.core.order;

/**
 * @desc: 주문 서비스 구현체
 */

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor // final 키워드 보고 생성자를 만들어주는 lombok 라이브러리
public class OrderServiceImpl implements OrderService{

    // 주문 서비스 -> 회원 저장소, 할인정책 필요함
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // ✔ 구체 구현에도 의존중 DIP위반(인터페이스 의존)
    // private final DiscountPolicy discountPolicy  = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy  = new RateDiscountPolicy();

    // 해결하는법
    // 인터페이스에만 의존하는 중
    private  final MemberRepository memberRepository;
    private  final DiscountPolicy discountPolicy;


//    @RequiredArgsConstructor 대신 만들어줌
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       // 멤버 찾기
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
