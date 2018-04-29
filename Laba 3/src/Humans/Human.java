package Humans;

import Items.Food;

import java.util.ArrayList;

public abstract class Human {
    private String name;

    protected Human() {
        name = "";
    }

    protected Human (String name) {
        this.name = name;
    }

    protected void setName (String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    abstract void eat (ArrayList<Food> foodList);
}
