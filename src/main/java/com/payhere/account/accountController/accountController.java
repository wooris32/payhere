package com.payhere.account.accountController;


import com.payhere.account.board.mapper.BoardMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class accountController {

    @Resource(name = "com.payhere.account.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;
//
//    @RequestMapping("/")
//    public String login() throws Exception{
//        System.out.println(mBoardMapper.boardCount());
//        return "test";
//    }
//    @RequestMapping("/test")
//    public String jspTest() throws Exception{
//        System.out.println(mBoardMapper.boardCount());
//        return "test";
//    }
}
