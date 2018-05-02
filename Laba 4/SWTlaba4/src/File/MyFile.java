package File;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ����� ��� ������ � ������� .txt
 *
 */
public class MyFile {

    private final String logFilename = "C:\\Users\\yurev\\eclipse-workspace\\SWTlaba4\\src\\data\\log.txt";
    private final String resultFilename = "C:\\Users\\yurev\\eclipse-workspace\\SWTlaba4\\src\\data\\Strings.txt";

    private String filename;

    /**
     * ����������� � �����������
     * @param f ���� � �����
     */
    public MyFile(String f) {
        filename = f;
    }

    /**
     * ����������� �� ���������
     */
    public MyFile() {
    }

    /**
     * ������ � ���� �������
     * @param c �������� ����
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
     * ������� ������� �� ����� ������
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
     * ������ � ���� ����������� � ������� ������� �� ����� ������
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
     * ������ ������ � ����������� ��������� ������� �� ����� ������
     * @param s �������� ������
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
     * ������� �����
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
     * @return ��� ����� ����
     */
    public String getLogFilename() {
        return logFilename;
    }

    /**
     * @return ��� ����� �� ��������
     */
    public String getResultFilename() {
        return resultFilename;
    }
}
