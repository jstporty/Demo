package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPloicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.repository.MemberRepository;
import com.hello.core.member.repository.MemoryMemberRepository;
import com.hello.core.member.service.MemberService;
import com.hello.core.member.service.MemberServiceImpl;
import com.hello.core.order.Order;
import com.hello.core.order.service.OrderService;
import com.hello.core.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPloicy();
        return new RateDiscountPolicy();
    }
}
