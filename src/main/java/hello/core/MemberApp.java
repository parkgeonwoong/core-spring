package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        // AppConfig(외부)에서 어떤 구현 객체를 주입할지 정한다
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member: " + findMember.getName());

    }
}
