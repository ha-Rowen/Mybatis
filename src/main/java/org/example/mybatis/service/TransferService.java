package org.example.mybatis.service;


import org.example.mybatis.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final MemberMapper  membermapper;
    private final LogService LT;
    public TransferService(MemberMapper membermapper , LogService LT)
    {
        this.LT= LT;
        this.membermapper = membermapper;
    }


    @Transactional
    public void transhfer(Long fromId, Long toId, int amount)
    {
        this.getMoney(fromId,amount);
        this.setMoney(toId, amount);
        LT.Test_Log();
        /*예외가 발생하도록 유도하였다. 의도는 Test_Log의 물리트랜잭션은 분리하여 해당 메서드가 실패해도 입력에 성공한다*/

    }




    @Transactional
    public int getMoney ( Long fromId , int amount )
    {
        int withdrawResult = membermapper.get_money(fromId,amount);
        if(withdrawResult== 0)
            throw new RuntimeException("잔액이 부족합니다.");
        return withdrawResult;
    }

    @Transactional
    public int setMoney( Long toId, int amount )
    {
        int depositResult = membermapper.set_money(toId,amount);
        if(depositResult == 0)
            throw new RuntimeException("입금 실패");

        return depositResult;
    }
}
