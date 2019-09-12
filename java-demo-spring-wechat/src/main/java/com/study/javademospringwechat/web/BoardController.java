package com.study.javademospringwechat.web;

import com.study.javademospringwechat.entity.Board;
import com.study.javademospringwechat.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> getList(){
       List<Board> boardList= boardService.getBoardList();
       Map<String,Object> result=new HashMap<>();
       result.put("list",boardList);
       return  result;
    }

    @RequestMapping(value = "/getBoardById")
    public Map<String,Object> getBoardById(@NotNull Integer id){
      Board board= boardService.getBoardById(id);
      Map<String,Object> result=new HashMap<>();
      result.put("board",board);
      return result;
    }

    @RequestMapping(value = "/addBoard",method = RequestMethod.POST)
    public Map<String,Object> addBoard(@RequestBody Board board){
        Boolean bool= boardService.addBoard(board);
        Map<String,Object> result=new HashMap<>();
        result.put("result",bool);
        return result;
    }
}
