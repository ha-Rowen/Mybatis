package org.example.mybatis.service;


import org.example.mybatis.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final MemberMapper  membermapper;

    public TransferService(MemberMapper membermapper)
    {
        this.membermapper = membermapper;
    }
    public void start()
    {
      System.out.println(membermapper.selectAll());
    }
    @Transactional
    public void transhfer(Long fromId, Long toId, int amount)
    {

        int withdrawResult = membermapper.get_money(fromId,amount);
        if(withdrawResult== 0)
                 throw new RuntimeException("잔액이 부족합니다.");

        int depositResult = membermapper.set_money(toId,amount);
        if(depositResult == 0)
           throw new RuntimeException("입금 실패");

    }
}
