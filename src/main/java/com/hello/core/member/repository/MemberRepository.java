package com.hello.core.member.repository;

import com.hello.core.member.Member;

public interface MemberRepository {

    void save (Member member);

    Member findById(Long memberId);

}
