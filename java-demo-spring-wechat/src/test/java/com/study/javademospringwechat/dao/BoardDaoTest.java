package com.study.javademospringwechat.dao;

import com.study.javademospringwechat.entity.Board;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardDaoTest {
    @Autowired
    private BoardDao boardDao;

    @Test
    public void testqueryBoard() {
        List<Board> boards=boardDao.queryBoard();
        System.out.println(boards.get(0));
    }

    @Test
    @Ignore
    public void queryBoardById() {
    }

    @Test
    @Ignore
    public void insertBoard() {
    }

    @Test
    @Ignore
    public void updateBoard() {
    }

    @Test
    @Ignore
    public void deleteBoard() {
    }
}