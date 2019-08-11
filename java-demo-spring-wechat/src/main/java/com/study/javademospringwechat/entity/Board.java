package com.study.javademospringwechat.entity;

import lombok.Data;

@Data
public class Board {
    private Integer id;
    private String userName;
    private String content;
    private Integer createTime;
}
