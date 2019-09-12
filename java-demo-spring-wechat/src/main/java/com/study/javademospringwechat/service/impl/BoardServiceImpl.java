package com.study.javademospringwechat.service.impl;

import com.study.javademospringwechat.dao.BoardDao;
import com.study.javademospringwechat.entity.Board;
import com.study.javademospringwechat.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<Board> getBoardList() {
        return boardDao.queryBoard();
    }

    @Override
    public Board getBoardById(Integer id) {
        return boardDao.queryBoardById(id);
    }

    @Transactional
    @Override
    public Boolean addBoard(Board board) {
        //判空
        if (board.getUserName() != null
                && !board.getUserName().equals("")
                && board.getContent() != null) {
            try {
                int effectNum = boardDao.insertBoard(board);
                board.setCreateTime(Math.toIntExact(new Date().getTime() / 1000));
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("参数不能为空");
        }
    }

    @Transactional
    @Override
    public Boolean updateBoard(Board board) {
        if (board.getId() != null && !board.getId().equals(0)) {
            try{
                int effectNum = boardDao.updateBoard(board);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("参数不合法");
        }
    }

    @Transactional
    @Override
    public Boolean deleteBoardById(Integer id) {
        if (id!=null&&!id.equals(0)) {
            try{
                Board board=new Board();
                board.setId(id);
                int effectNum= boardDao.deleteBoard(board);
                if (effectNum>0) {
                    return true;
                }else{
                    throw new RuntimeException("删除失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除失败:"+e.getMessage());
            }

        }else {
            throw new RuntimeException("参数不合法");
        }
    }
}
