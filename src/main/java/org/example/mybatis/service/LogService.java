package org.example.mybatis.service;

import org.example.mybatis.mapper.MemberMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    private final MemberMapper membermapper;

    public LogService(MemberMapper membermapper)
    {

        this.membermapper = membermapper;
    }

    @Async //
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void Test_Log()  {
        System.out.println(membermapper.selectAll());
        throw new RuntimeException("로그 시스템 장애발생");
    }
}
