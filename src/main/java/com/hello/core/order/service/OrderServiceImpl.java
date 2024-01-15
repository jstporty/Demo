package com.hello.core.order.service;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPloicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.repository.MemberRepository;
import com.hello.core.member.repository.MemoryMemberRepository;
import com.hello.core.order.Order;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final  MemberRepository memberRepository;

    //    private final DiscountPolicy discountPolicy = new FixDiscountPloicy();
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
