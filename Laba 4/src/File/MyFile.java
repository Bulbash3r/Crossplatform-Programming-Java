package File;

import java.io.FileWriter;
import java.io.IOException;

public class MyFile {

    private final String logFilename = "C:\\Users\\yurev\\Documents\\GitHub\\Java-Labs\\Laba 4\\src\\data\\log.txt";
    private final String resultFilename = "C:\\Users\\yurev\\Documents\\GitHub\\Java-Labs\\Laba 4\\src\\data\\Strings.txt";

    private String filename;

    public MyFile(String f) {
        filename = f;
    }

    public MyFile() {
    }

    /**
     * Запись данных файл
     * @param c строка, которую нужно записать
     */
    public void write(char c) {
        try (FileWriter writer = new FileWriter (filename, true)) {
            writer.write(c);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewLine() {
        try (FileWriter writer = new FileWriter (filename, true)) {
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeln(String s) {
        try (FileWriter writer = new FileWriter (filename, true)) {
            writer.write(s);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogFilename() {
        return logFilename;
    }

    public String getResultFilename() {
        return resultFilename;
    }
}
