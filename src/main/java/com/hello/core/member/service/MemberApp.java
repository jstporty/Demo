package com.hello.core.member.service;

import com.hello.core.AppConfig;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.service.MemberService;
import com.hello.core.member.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member =  " + member.getName());
        System.out.println("find member =  " + findMember.getName());
    }
}
