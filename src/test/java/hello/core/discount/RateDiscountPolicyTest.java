package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        // 테스트 상태를 설명
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        // 구체화하고자 하는 그 행동
        int discount = discountPolicy.discount(member, 10000);

        // then
        // 어떤 특정한 행동 때문에 발생할거라고 예상되는 변화
        assertThat(discount).isEqualTo(1000);
    }


    // 실패 테스트
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        // 테스트 상태를 설명
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        // 구체화하고자 하는 그 행동
        int discount = discountPolicy.discount(member, 10000);

        // then
        // 어떤 특정한 행동 때문에 발생할거라고 예상되는 변화
        assertThat(discount).isEqualTo(0);
    }

};

