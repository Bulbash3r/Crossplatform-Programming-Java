import java.util.Scanner;
import Scala_objects.Occurrences;

public class cOccurrences {
    public static void main(String[] args) {
        final String bigWord = new BigWord().getWord();

        System.out.print("Введите символ для поиска: ");
        char c = new Scanner(System.in).nextLine().charAt(0);
        int acc = 0;
        System.out.println("Длина слова: " + bigWord.length() + " символов");
        System.out.println("Символ для поиска: " + c);

        long startTime = System.nanoTime();
        System.out.println(Occurrences.occurrences(bigWord, c));
        long finishTime = System.nanoTime();

        long startTailTime = System.nanoTime();
        System.out.println(Occurrences.tailOccurrences(acc, bigWord, c));
        long finishTailTime = System.nanoTime();

        System.out.println("Не хвостовая рекурсия: " + (finishTime-startTime)/1000000 + " мс");
        System.out.println("Хвостовая рекурсия: " + (finishTailTime-startTailTime)/1000000 + " мс");
    }
}
