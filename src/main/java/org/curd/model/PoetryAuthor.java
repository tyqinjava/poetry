package org.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "poetry_author")
public class PoetryAuthor implements Serializable, MetaType {

    @Id
    private Integer id;

    private String name;
    private String intro;
    private Character dynasty;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Character getDynasty() {
        return dynasty;
    }

    public void setDynasty(Character dynasty) {
        this.dynasty = dynasty;
    }

    @Override
    public String tableName() {
        return "poetry_author";
    }

    @Override
    public String primaryKeyName() {
        return "id";
    }
}
