package Thread;
import File.*;

public abstract class MyThread extends Thread {

	protected String str;
    protected MyFile file;
    protected int num;
    
    public MyThread(String str, MyFile file, int num) {
        this.str = str;
        this.file = file;
        this.num = num;
    }
    
    public abstract void run();
}
