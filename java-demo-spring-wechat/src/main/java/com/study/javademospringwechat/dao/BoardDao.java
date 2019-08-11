package com.study.javademospringwechat.dao;

import com.study.javademospringwechat.entity.Board;

import java.util.List;

public interface BoardDao {
    /**
     * 查询留言板列表
     * @return
     */
    List<Board> queryBoard();


    /**
     * 根据id 获取单条留言板信息
     * @param id
     * @return
     */
    Board queryBoardById(int id);

    /**
     * 插入留言板信息
     * @param board
     * @return
     */
    int insertBoard(Board board);

    /**
     * 更新留言板信息
     * @param board
     * @return
     */
    int updateBoard(Board board);

    /**
     * 删除留言板信息
     * @param board
     * @return
     */
    int deleteBoard(Board board);

}
