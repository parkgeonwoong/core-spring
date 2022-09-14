package hello.core.discount;

/**
 * @desc: 할인정책 역할 (인터페이스)
 */

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return: 할인 대상 금액
     */
    int discount(Member member, int price);


}
