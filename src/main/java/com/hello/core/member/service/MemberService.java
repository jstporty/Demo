package com.hello.core.member.service;

import com.hello.core.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
