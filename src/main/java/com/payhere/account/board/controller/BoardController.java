package com.payhere.account.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.payhere.account.board.domain.UserVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.payhere.account.board.domain.BoardVO;
import com.payhere.account.board.service.BoardService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.text.SimpleDateFormat;


@Controller
public class BoardController {
    private static boolean CONTROL_FLAG = true;
    @Resource(name="com.payhere.account.board.service.BoardService")
    BoardService mBoardService;

    @RequestMapping("/list")// 리스트 화면 호출
    private String boardList(Model model) throws Exception{
        return "redirect:/login_success";
    }


    @RequestMapping("/detail/{bno}")
    private String boardDetail(@PathVariable int bno, Model model) throws Exception{
        model.addAttribute("detail", mBoardService.boardDetailService(bno));

        return "detail";
    }

    @RequestMapping("/insert") //게시글 작성폼 호출
    private String boardInsertForm(){
        return "insert";
    }

    @RequestMapping("/insertProc")
    private String boardInsertProc(BoardVO boardVO) throws Exception{

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boardVO.setUserId(((UserDetails) principal).getUsername());
        boardVO.setSts("C");

        mBoardService.boardInsertService(boardVO);
        return "redirect:/list";
    }

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return userDetails.getUsername();
    }

    @RequestMapping("/update/{bno}") //게시글 수정폼 호출
    private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{
        model.addAttribute("detail", mBoardService.boardDetailService(bno));
        return "update";
    }

    @RequestMapping("/updateProc")
    private String boardUpdateProc(BoardVO board) throws Exception{
        board.setSts("U");
        mBoardService.boardUpdateService(board);
        return "redirect:/detail/"+board.getBno();
    }

    @RequestMapping("/delete/{bno}")
    private String boardDelete(@PathVariable int bno) throws Exception{
        BoardVO board = new BoardVO();
        board.setSts("D");
        board.setBno(bno);
        mBoardService.boardDeleteService(board);
        return "redirect:/list";
    }

    @RequestMapping("/history")
    public String history(Model model) throws Exception{

        CONTROL_FLAG=false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("flag",CONTROL_FLAG);
        model.addAttribute("list", mBoardService.boardListService(((UserDetails) principal).getUsername() , CONTROL_FLAG));

        return "boardPage";
    }
}
