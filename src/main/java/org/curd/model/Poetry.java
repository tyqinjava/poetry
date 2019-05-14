package org.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "poetry")
public class Poetry implements Serializable, MetaType {

    @Id
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

    @Override
    public String tableName() {
        return "poetry";
    }

    @Override
    public String primaryKeyName() {
        return "id";
    }
}
