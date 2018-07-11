package com.expand.models;

import java.util.List;

/**
 * Created by teo on 11/7/2018.
 */

public class Parent {

    private String id;
    private String name;

    private List<Child> childIDs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildIDs() {
        return childIDs;
    }

    public void setChildIDs(List<Child> childIDs) {
        this.childIDs = childIDs;
    }
}
