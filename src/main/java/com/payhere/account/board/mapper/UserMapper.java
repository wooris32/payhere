package com.payhere.account.board.mapper;

import com.payhere.account.board.domain.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.payhere.account.board.mapper.UserMapper")
public interface UserMapper {
    // 회원가입 처리
    void registerAction(UserVO user);

    UserVO loginAction(String userId);
}

