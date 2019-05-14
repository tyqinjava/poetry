package org.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "lunyu")
public class LunYu implements Serializable, MetaType {

    @Id
    private Integer id;

    private String chapter;

    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String tableName() {
        return "lunyu";
    }

    @Override
    public String primaryKeyName() {
        return "id";
    }
}
