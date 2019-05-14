package org.curd.dto;

import java.io.Serializable;

public class PoetryAuthorDto implements Serializable {

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
}
