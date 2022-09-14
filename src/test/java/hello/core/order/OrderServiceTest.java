package hello.core.order;
/**
 * @desc: 주문과 할인 정책 테스트
 */

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // assertThat구문은 어떤조건이 참인지 확인하는 구문
        // isEqualTo는 대상의 내용자체를 비교한다.
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
