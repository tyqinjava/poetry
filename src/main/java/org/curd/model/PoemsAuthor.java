package org.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "poems_author")
public class PoemsAuthor implements Serializable , MetaType {

    @Id
    private Integer id;
    private String name;
    private String introL;
    private String introS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroL() {
        return introL;
    }

    public void setIntroL(String introL) {
        this.introL = introL;
    }

    public String getIntroS() {
        return introS;
    }

    public void setIntroS(String introS) {
        this.introS = introS;
    }

    @Override
    public String tableName() {
        return "poems_author";
    }

    @Override
    public String primaryKeyName() {
        return "id";
    }
}
