package com.example.experience_platform.board.controller;

import com.example.experience_platform.board.service.BoardService;
import com.example.experience_platform.board.vo.BoardVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board") // 프록시와 맞춤
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //전체조회
    @GetMapping
    public List<BoardVo> getAllBoards() {
        return boardService.getAllBoards();
    }

    //단일조회
    @GetMapping("/{boardId}")
    public BoardVo getBoard(@PathVariable Long boardId) {
        return boardService.getBoardById(boardId);
    }

    //게시글생성
    @PostMapping
    public String createBoard(@RequestBody BoardVo boardVo) {
        return boardService.createBoard(boardVo) == 1 ? "게시글 등록 성공" : "게시글 등록 실패";
    }

    //게시글수정
    @PutMapping("/{boardId}")
    public String updateBoard(@PathVariable Long boardId, @RequestBody BoardVo boardVo) {
        boardVo.setBoardId(boardId);
        return boardService.updateBoard(boardVo) == 1 ? "게시글 수정 성공" : "게시글 수정 실패";
    }

    @DeleteMapping("/multiple")
    public String deleteBoards(@RequestBody List<Long> boardIds) {
        boardService.deleteBoard(boardIds); // 반환값 신경 안쓰고 삭제만
        return "선택한 게시글 삭제 완료";
    }
}