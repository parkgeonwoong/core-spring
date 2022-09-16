package hello.core;

/**
 * @desc: 주문과 할인 정책 실행
 */


import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        // AppConfig에서 꺼내서 쓰자
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // 인터페이스의 구현체 멤버 설정
        // MemberService memberService = new MemberServiceImpl(null);
        // OrderService orderService = new OrderServiceImpl(null, null);

        // member 저장
        Long memberId = 1L;
        // 회원 한명 만들기
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // 메모리 객체에 넣기 = 주문해서 찾아서 쓸수 있으니까
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
