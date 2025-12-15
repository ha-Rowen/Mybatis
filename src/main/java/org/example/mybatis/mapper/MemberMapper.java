package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.userEntity;

import java.util.List;
@Mapper
public interface MemberMapper {

    List<userEntity> selectAll();

    // select * from member where id =#{id}
    userEntity  selectById(@Param("id") Long id);
    int  set_money(@Param("id") Long id,@Param("money") int money);
    int  get_money(@Param("id") Long id,@Param("money") int money);

}
