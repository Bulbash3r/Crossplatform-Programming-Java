package Thread;
import File.*;

public class SynchronizedThread extends MyThread {

    public SynchronizedThread(String str, MyFile file, int num) {
        super (str, file, num);
    }

    public void run() {
        synchronized (file) {
            MyFile log = new MyFile(new MyFile().getLogFilename());
            log.writeln("������������������ ����� �"+ num +" ����� ������");
            for (int i=0; i<str.length(); i++) {
                file.write(str.charAt(i));
            }
            file.writeNewLine();
            log.writeln("������������������ ����� �"+ num +" �������� ������");
        }
    }
}
