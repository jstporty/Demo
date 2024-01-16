package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.repository.MemberRepository;
import com.hello.core.member.repository.MemoryMemberRepository;
import com.hello.core.member.service.MemberService;
import com.hello.core.member.service.MemberServiceImpl;
import com.hello.core.order.service.OrderService;
import com.hello.core.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        //1번
        System.out.println("call AppConfig.memberService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        //2번? 3번?
        System.out.println("call AppConfig.memberService");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
