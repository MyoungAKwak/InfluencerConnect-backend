package com.example.experience_platform.board.mapper;

import com.example.experience_platform.board.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVo> selectAll();

    BoardVo selectById(Long boardId);

    int insert(BoardVo boardVo);

    int update(BoardVo boardVo);

    int delete(Long boardId);
}