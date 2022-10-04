package com.payhere.account.board.service;

import com.payhere.account.board.domain.UserVO;
import com.payhere.account.board.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

@Service("com.payhere.account.board.service.UserService")
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Resource(name="com.payhere.account.board.mapper.UserMapper")
    UserMapper userMapper;

    Date time = new Date();
    SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:sss"); // 현재 시각을 나타내기 위한 포맷

    public void saveUserData(UserVO userVO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPassword(passwordEncoder.encode(userVO.getUserPassword()));
        userVO.setUserAuth("USER");
        userVO.setCreatedDate(format.format(time).toString());
        userMapper.registerAction(userVO);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserVO userVO = userMapper.loginAction(userId);
        if(userVO==null){
            throw new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다.");
        }
        return userVO;
    }
}
