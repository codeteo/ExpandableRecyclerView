package com.expand.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by teo on 11/7/2018.
 */

public class Parent extends ExpandableGroup<Child> {

    private String id;
    private String name;

    private List<Child> childIDs;

    public Parent(String title, List<Child> items) {
        super(title, items);
    }

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
