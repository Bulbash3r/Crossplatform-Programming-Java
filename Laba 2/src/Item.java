/**
 * Класс предмет
 */
class Item {
    /** Название предмета*/
    private String name;

    /**
     * Конструктор с параметрами
     * @param ItemName - название предмета
     */
    Item(String ItemName) {
        name = ItemName;
    }

    /**
     * Сетер названия предмета
     * @param n название предмета
     */
    void setName(String n) {
        name = n;
    }

    /**
     * @return название предмета
     */
    String getName() {
        return name;
    }
}