package com.expand.models;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

/**
 * Created by teo on 11/7/2018.
 */

public class Parent extends MultiCheckExpandableGroup {

    private int id;
    private String name;

    private List<Child> childIDs;

    public Parent(int id, String title, List<Child> items) {
        super(title, items);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
