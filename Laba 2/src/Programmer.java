import java.util.Random;
import java.lang.String;

/**
 * Класс Программист
 */
class Programmer extends Human {
    /** Число, используемое для рандомайза количества символов*/
    private static final int RAND_SIZE = 150;
    /** Минимальное количество символов*/
    private final int MIN_RAND = 50;
    /** Алфавит, используемый при создании Программистом кода*/
    private final String alphabet = ("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890(){}[]<>=!,");

    /**
     * Конструктор по умолчанию
     */
    Programmer() {
        super ();
    }

    /**
     * Конструктор с параметрами
     * @param name имя
     */
    Programmer (String name) {
        super(name);
    }

    /**
     * @return набор символов, являющийся "кодом", написанным Программистом
     */
    String coding(){
        Random rand = new Random();
        int size = rand.nextInt(RAND_SIZE) + MIN_RAND;
        String code = "";
        for (int i=0; i<size; i++)
        {
            char a = alphabet.charAt(rand.nextInt(alphabet.length()));
            code+=a;
        }
        return code;
    }
}