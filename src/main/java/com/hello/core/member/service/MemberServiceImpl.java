package com.hello.core.member.service;

import com.hello.core.member.Member;
import com.hello.core.member.repository.MemberRepository;
import com.hello.core.member.repository.MemoryMemberRepository;
import com.hello.core.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}