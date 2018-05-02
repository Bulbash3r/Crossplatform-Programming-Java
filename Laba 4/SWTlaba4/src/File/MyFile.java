package File;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для работы с файлами .txt
 *
 */
public class MyFile {

    private final String logFilename = "C:\\Users\\yurev\\eclipse-workspace\\SWTlaba4\\src\\data\\log.txt";
    private final String resultFilename = "C:\\Users\\yurev\\eclipse-workspace\\SWTlaba4\\src\\data\\Strings.txt";

    private String filename;

    /**
     * Конструктор с параметрами
     * @param f путь к файлу
     */
    public MyFile(String f) {
        filename = f;
    }

    /**
     * Конструктор по умолчанию
     */
    public MyFile() {
    }

    /**
     * Запись в файл символа
     * @param c вводимый файл
     */
    public void write(char c) {
        try (FileWriter writer = new FileWriter (filename, true)) {
            writer.write(c);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Перевод каретки на новую строку
     */
    public void writeNewLine() {
        try (FileWriter writer = new FileWriter (filename, true)) {
        	writer.append("\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Запись в файл разделителя и перевод каретки на новую строку
     */
    public void writeSeparator() {
        try (FileWriter writer = new FileWriter (filename, true)) {
        	writer.write("======================");
        	writer.append("\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Запись строки с последующим переводом каретки на новую строку
     * @param s вводимая строка
     */
    public void writeln(String s) {
        try (FileWriter writer = new FileWriter (filename, true)) {
            writer.write(s);
            writer.append("\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Очистка файла
     */
    public void clear() {
    	try {
            FileWriter writer = new FileWriter(filename, false);
            writer.write("");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * @return имя файла лога
     */
    public String getLogFilename() {
        return logFilename;
    }

    /**
     * @return имя файла со строками
     */
    public String getResultFilename() {
        return resultFilename;
    }
}
