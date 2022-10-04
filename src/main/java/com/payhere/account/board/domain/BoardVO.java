package com.payhere.account.board.domain;

import java.util.Date;

public class BoardVO {

    private int bno;
    private String subject;
    private String content;
    private String writer;
    private String user_id;
    private Date reg_date;
    private Date use_date;
    private Double amount;
    private String sts;
    private String typea;


    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getTypea() {
        return typea;
    }


    public void setTypea(String typea) {
        this.typea = typea;
    }

    public Date getUseDate() {
        return use_date;
    }

    public void setUseDate(Date use_date) {
        this.use_date = use_date;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }


    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }


}
