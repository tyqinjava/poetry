package org.curd.dto;

import java.io.Serializable;


public class PoetryDto implements Serializable {

    private Integer id;
    private Integer authorId;
    private String title;
    private String content;
    private String yunlvRule;
    private String author;
    private Character dynasty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYunlvRule() {
        return yunlvRule;
    }

    public void setYunlvRule(String yunlvRule) {
        this.yunlvRule = yunlvRule;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Character getDynasty() {
        return dynasty;
    }

    public void setDynasty(Character dynasty) {
        this.dynasty = dynasty;
    }
}
