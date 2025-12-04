package com.example.experience_platform.board.service;

import com.example.experience_platform.board.mapper.BoardMapper;
import com.example.experience_platform.board.vo.BoardVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 전체 게시글 조회
    public List<BoardVo> getAllBoards() {
        return boardMapper.selectAll();
    }

    // 특정 게시글 조회
    public BoardVo getBoardById(Long boardId) {
        return boardMapper.selectById(boardId);
    }

    // 게시글 등록
    public int createBoard(BoardVo boardVo) {
        return boardMapper.insert(boardVo);
    }

    // 게시글 수정
    public int updateBoard(BoardVo boardVo) {
        return boardMapper.update(boardVo);
    }


    // 게시글 삭제
    public void deleteBoard(List<Long> boardIds) {
        for (int i = 0; i < boardIds.size(); i++) {
            boardMapper.delete(boardIds.get(i));
        }
    }

}