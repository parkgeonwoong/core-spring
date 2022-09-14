package hello.core.discount;

/**
 * @desc: 정액할인 정책
 */

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 1000원 할인
    private int discountFixAccount = 1000;

    @Override
    public int discount(Member member, int price) {

        // VIP일 경우 조건 1000원 할인
        if (member.getGrade() == Grade.VIP) {
            return discountFixAccount;
        } else {
            return 0;
        }
    }
}
