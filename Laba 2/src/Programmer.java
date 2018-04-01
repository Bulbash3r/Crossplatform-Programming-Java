import java.util.Random;
import java.lang.String;

class Programmer extends Human {
    private static final int RAND_SIZE = 50;

    Programmer() {
        super ();
    }
    Programmer (String name) {
        super(name);
    }

    String coding(){
        Random rand = new Random();
        int size = rand.nextInt(RAND_SIZE)+15;
        String code = "";
        String alphabet = ("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890(){}[]<>=!,");
        for (int i=0; i<size; i++)
        {
            char a = alphabet.charAt(rand.nextInt(alphabet.length()));
            code+=a;
        }
        return code;
    };
}