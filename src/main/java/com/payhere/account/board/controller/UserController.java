package com.payhere.account.board.controller;

import javax.annotation.Resource;

import com.payhere.account.board.service.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.payhere.account.board.domain.UserVO;
import com.payhere.account.board.service.UserService;
import org.springframework.security.core.Authentication;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Resource(name="com.payhere.account.board.service.UserService")
    private UserService userService;

    @RequestMapping("/")//게시판 리스트 화면 호출
    public String loginRedirect() throws Exception{
        return "loginpage";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginpage";
    }

    @GetMapping("/registerPage")
    public String RegisterPage(){
        return "registerpage";
    }

    @PostMapping("/register_action")
    public String registerAction(UserVO userVO){
        userService.saveUserData(userVO);
        return "redirect:/loginPage";
    }

    // 로그인 실패
    @GetMapping("/login_fail")
    public String loginFail(){
        return "loginfail";
    }

    @Resource(name="com.payhere.account.board.service.BoardService")
    BoardService mBoardService;
    // 로그인 성공
    // Authentication는 인증된 사용자의 이름, 권한 등을 불러오는 역할을 한다.
    @GetMapping("/login_success")
    public String loginSuccess(Model model, Authentication authentication) throws Exception{
        UserVO userDTO = (UserVO) authentication.getPrincipal();

        model.addAttribute("info",userDTO.getUserName2()+"님의 가계부");
        model.addAttribute("list", mBoardService.boardListService(userDTO.getUsername()));

        return "boardPage";
    }
}
