import java.util.ArrayList;

class Human {
    protected String name;

    Human() {
        name = null;
    }
    Human (String name) {
        this.name = name;
    }
    void setName(String n) {
        name = n;
    }
    String getName() {
        return name;
    }
    Taste eat(ArrayList<Food> fl) {
        Taste t = fl.get(fl.size()-1).getTaste();
        fl.remove(fl.size()-1);
        return t;
    }
}