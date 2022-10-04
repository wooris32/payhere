package com.payhere.account.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.payhere.account.board.domain.UserVO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.payhere.account.board.domain.BoardVO;
import com.payhere.account.board.service.BoardService;

@Controller
public class BoardController {
    @Resource(name="com.payhere.account.board.service.BoardService")
    BoardService mBoardService;
/*
    @RequestMapping("/list")//게시판 리스트 화면 호출
    private String boardList(Model model) throws Exception{
        model.addAttribute("list", mBoardService.boardListService());
        return "redirect:/login_success"; //생성할 jsp
    }*/


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
    private String boardInsertProc(HttpServletRequest request, Authentication authentication) throws Exception{
        BoardVO board = new BoardVO();
        board.setSubject(request.getParameter("subject"));
        board.setContent(request.getParameter("content"));
        board.setTypea(request.getParameter("type"));
        board.setAmount(Double.parseDouble(request.getParameter("amount")));
        board.setSts(request.getParameter("C"));

        mBoardService.boardInsertService(board);
        return "redirect:/login_success";
    }

    @RequestMapping("/update/{bno}") //게시글 수정폼 호출
    private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{
        model.addAttribute("detail", mBoardService.boardDetailService(bno));
        return "update";
    }

    @RequestMapping("/updateProc")
    private String boardUpdateProc(HttpServletRequest request) throws Exception{
        BoardVO board = new BoardVO();
        board.setSubject(request.getParameter("subject"));
        board.setContent(request.getParameter("content"));
        board.setBno(Integer.parseInt(request.getParameter("bno")));
        mBoardService.boardUpdateService(board);
        return "redirect:/detail/"+request.getParameter("bno");
    }

    @RequestMapping("/delete/{bno}")
    private String boardDelete(@PathVariable int bno) throws Exception{
        mBoardService.boardDeleteService(bno);
        return "redirect:/list";
    }
}
