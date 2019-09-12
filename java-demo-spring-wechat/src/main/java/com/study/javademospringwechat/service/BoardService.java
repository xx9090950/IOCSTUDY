package com.study.javademospringwechat.service;

import com.study.javademospringwechat.entity.Board;

import java.util.List;

public interface BoardService {
    /**
     * 获取列表
     * @return
     */
    List<Board> getBoardList();

    /**
     * 获取单条数据通过id
     * @param id
     * @return
     */
    Board getBoardById(Integer id);

    /**
     * 添加数据
     * @param board
     * @return
     */
    Boolean addBoard(Board board);

    /**
     * 更新数据
     * @param board
     * @return
     */
    Boolean updateBoard(Board board);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    Boolean deleteBoardById(Integer id);
}
