package Thread;
import File.*;

public class UnsynchronizedThread extends Thread {

    private String str;
    private MyFile file;
    private int num;

    public UnsynchronizedThread(String str, MyFile file, int num) {
        this.str = str;
        this.file = file;
        this.num = num;
    }

    public void run() {
        MyFile log = new MyFile(new MyFile().getLogFilename());
        log.writeln("Несинхронизированный поток №"+ num + 1 +" начал работу");
        for (int i=0; i<str.length(); i++) {
            file.write(str.charAt(i));
        }
        file.writeNewLine();
        log.writeln("Несинхронизированный поток №"+ num + 1 +" завершил работу");
    }
}
