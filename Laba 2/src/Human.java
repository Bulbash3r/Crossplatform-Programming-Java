import java.util.ArrayList;

/**
 * Класс Человек
 */
class Human {

    /** Имя человека*/
    private String name;

    /**
     * Конструктор по умолчанию
     */
    Human() {
        name = "";
    }

    /**
     * Конструктор с параметрами
     * @param name имя человека
     */
    Human (String name) {
        this.name = name;
    }

    /**
     * Сетер имени человека
     * @param n имя человека
     */
    void setName(String n) {
        name = n;
    }

    /**
     * @return имя человека
     */
    String getName() {
        return name;
    }

    /**
     * Метод "кушания". Удаляет блюдо из списка
     * @param fl список блюд
     * @return блюдо
     */
    Food eat(ArrayList<Food> fl) {
        Food f = fl.get(fl.size()-1);
        fl.remove(fl.size()-1);
        return f;
    }
}