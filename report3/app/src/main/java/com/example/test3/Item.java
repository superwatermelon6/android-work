package com.example.myapplication;

public class Item {
    private String name;
    private Boolean selected;

    public Item() {
        super();
    }
    public Item(Boolean selected, String name) {
        this.selected = selected;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }
}
