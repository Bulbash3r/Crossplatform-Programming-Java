import org.eclipse.swt.*;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import File.MyFile;
import Thread.*;

import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {
		
		MyFile file = new MyFile(new MyFile().getResultFilename());
        MyFile log = new MyFile(new MyFile().getLogFilename());
        log.writeln("Главный поток начал работу");
        ArrayList<String> str = new ArrayList<String>();
        str.add("Kewbr");
        str.add("Rick & Morty");
        str.add("EPAM vs. iTechArt");
        str.add("Мои любимые юморески");
        
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize (300,200);
		shell.setText("Laba 4");
		
		Label msSize = new Label (shell, SWT.NONE);
		msSize.setText("Количество слов: " +str.size());
		msSize.pack();
		
		Button add = new Button (shell, SWT.NONE);
		add.setText("Добавить слово");
		add.pack();
		
		Button write = new Button (shell, SWT.NONE);
		write.setText("Запись в файл");
		write.pack();
		
		Button open = new Button (shell, SWT.PUSH);
		open.setText("Открыть файл");
		open.pack();
		
		Text word = new Text (shell, SWT.NONE);
		word.pack();
		
		Group syncGroup = new Group (shell, SWT.NONE);
		Button sync = new Button (syncGroup, SWT.RADIO);
		Button unsync = new Button (syncGroup, SWT.RADIO);
		sync.setText("Синхр. запись");
		unsync.setText("Несинхр. запись");
		
		word.setBounds(10, 15, 130, 20);
		add.setBounds(10, 45, 130, 30);
		msSize.setBounds(10, 85, 130, 20);
		syncGroup.setLayout(new RowLayout(SWT.VERTICAL));
		write.setBounds(10, 110, 265, 40);
		open.setBounds(150, 72, 125, 30);
		syncGroup.setBounds(150, 5, 125, 60);
		sync.setSelection(true);		
		
		Listener addListener = new Listener() {
			public void handleEvent (Event event) {
				if (!word.getText().equals("")) {
					str.add(word.getText());
					word.setText("");
					msSize.setText("Количество слов: "+str.size());
				}
			}
		};
		
		Listener writeListener = new Listener() {
			public void handleEvent (Event event) {
				if (sync.getSelection() && !str.isEmpty()) {
					file.writeln("Синхронизированный вывод:");
			        for (int i=0; i<str.size(); i++) {
			            SynchronizedThread t = new SynchronizedThread(str.get(i), file, i);
			            t.start();
			        }
			        file.writeSeparator();
			        MessageBox mb = new MessageBox (shell, SWT.ICON_INFORMATION);
			        mb.setText("Выполнено!");
			        mb.setMessage("Синхронизированная запись в файл выполнена успешно!");
			        mb.open();
				}
				else if (unsync.getSelection() && !str.isEmpty()) {
					file.writeln("Несинхронизированный вывод:");
			        for (int i=0; i<str.size(); i++) {
			            UnsynchronizedThread t = new UnsynchronizedThread(str.get(i), file, i);
			            t.start();
			        }
			        file.writeSeparator();
			        MessageBox mb = new MessageBox (shell, SWT.ICON_INFORMATION);
			        mb.setText("Выполнено!");
			        mb.setMessage("Несинхронизированная запись в файл выполнена успешно!");
			        mb.open();
				}
			}
		};
		
		Listener openListener = new Listener() {
			public void handleEvent (Event event) {
				File file = new File (new MyFile().getResultFilename());
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		open.addListener (SWT.Selection, openListener);
		write.addListener(SWT.Selection, writeListener);
		add.addListener  (SWT.Selection, addListener);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
		
		log.writeln("Главный поток завершил работу");
		log.clear();
		file.clear();
		}
}