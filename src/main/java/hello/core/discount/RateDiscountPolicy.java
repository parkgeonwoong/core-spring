package hello.core.discount;

/**
 * @desc: 정률정책 구현체
 */

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    // 10% 할인
    private int discountPercent = 10;


    @Override
    // Ctrl + Shift + T = 테스트 만들어줌
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
