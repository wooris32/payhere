package com.payhere.account.board.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.payhere.account.board.domain.BoardVO;
import com.payhere.account.board.mapper.BoardMapper;

@Service("com.payhere.account.board.service.BoardService")
public class BoardService {
    @Resource(name="com.payhere.account.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;
    public List<BoardVO> boardListService(String userId) throws Exception{
        return mBoardMapper.boardList(userId);
    }

    public BoardVO boardDetailService(int bno) throws Exception{
        return mBoardMapper.boardDetail(bno);
    }

    public int boardInsertService(BoardVO board) throws Exception{
        return mBoardMapper.boardInsert(board);
    }

    public int boardUpdateService(BoardVO board) throws Exception{
        return mBoardMapper.boardUpdate(board);
    }

    public int boardDeleteService(int bno) throws Exception{
        return mBoardMapper.boardDelete(bno);
    }
}
