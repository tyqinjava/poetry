package org.curd.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "shijing")
public class ShiJing implements Serializable , MetaType {

    @Id
    private Integer id;

    private String title;

    private String chapter;

    private String section;

    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String tableName() {
        return "shijing";
    }

    @Override
    public String primaryKeyName() {
        return "id";
    }
}
