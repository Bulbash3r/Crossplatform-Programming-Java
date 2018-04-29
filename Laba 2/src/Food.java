/**
 * Класс Еда
 */
class Food extends Item {

    /** Вкус блюда*/
    private Taste taste;

    /**
     * Конструктор с параметрами
     * @param ItemName название блюда
     */
    Food(String ItemName) {
        super(ItemName);
        this.taste = Taste.TASTELESS;
    }

    /**
     * Конструктор с параметрами
     * @param taste вкус блюда
     * @param ItemName название блюда
     */
    Food(Taste taste, String ItemName){
        super(ItemName);
        this.taste = taste;
    }

    /**
     * @return вкус блюда
     */
    Taste getTaste() {
        return taste;
    }

    /**
     * @return строку, эквивалентную вкусу блюда
     */
    String tasteToString() {
        switch (taste)
        {
            case SWEET: return "Сладкий";
            case SOUR: return "Кислый";
            case SALTY: return "Солёный";
            case BITTER: return "Горький";
        }
        return "Безвкусный";
    }
}