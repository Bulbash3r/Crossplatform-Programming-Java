import File.MyFile;
import Thread.*;

public class Main {

    public static void main(String[] args) {

        MyFile file = new MyFile(new MyFile().getResultFilename());
        MyFile log = new MyFile(new MyFile().getLogFilename());
        log.writeln("Главный поток начал работу");

        String[] str = {"1ABCDE", "2qwerty", "3Lolkek", "4Луцик - герой Советского союза", "5kekekeke", "6dfhgffvcn", "7gfhfn"};

        file.writeln("Синхронизированный вывод:");
        for (int i=0; i<str.length; i++) {
            SynchronizedThread t = new SynchronizedThread(str[i], file, i);
            t.start();
        }
        file.writeNewLine();

        file.writeln("Несинхронизированный вывод:");
        for (int i=0; i<str.length; i++) {
            UnsynchronizedThread t = new UnsynchronizedThread(str[i], file, i);
            t.start();
        }

        log.writeln("Главный поток завершил работу");
    }
}
