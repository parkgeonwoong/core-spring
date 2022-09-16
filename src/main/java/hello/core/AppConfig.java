package hello.core;

/**
 * @desc: 구현객체를 생성, 연결하는 클래스
 * AppConfig(외부)에서 어떤 구현 객체를 주입할지 정한다
 */

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /**
     * @desc: 리팩토링 -> 중복 제거 및 한눈에 들어오게
     *  역할이 메소드명 구현 = new ...
     */

//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    // 멤버 서비스
    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 주문 서비스
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
