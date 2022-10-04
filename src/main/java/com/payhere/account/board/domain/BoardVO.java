package com.payhere.account.board.domain;
import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    private int bno;
    private String subject;
    private String content;
    private String userId;
    private Date regDate;
    private String useDate;
    private Double amount;
    private String sts;
    private String typea;
}
