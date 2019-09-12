package com.study.javademospringwechat.service.impl;

import com.study.javademospringwechat.entity.Board;
import com.study.javademospringwechat.service.BoardService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BoardServiceImplTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void getBoardList() {
       List<Board> boardList =boardService.getBoardList();
       System.out.println(boardList);
    }

    @Test
    @Ignore
    public void getBoardById() {
    }

    @Test
    @Ignore
    public void addBoard() {
    }

    @Test
    @Ignore
    public void updateBoard() {
    }

    @Test
    @Ignore
    public void deleteBoardById() {
    }
}