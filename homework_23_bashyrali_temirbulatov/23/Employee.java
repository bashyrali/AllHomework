import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;

import java.io.FileReader;
import java.io.FileWriter;


public class Employee {
    File file;
    File[] dirs;
    File[] files;
    public Employee(String pathname, String filename) {
        super();
        file = new File(pathname, filename); 
    }

    public void appendToFile(String file, String text) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(text+"\n");
        } catch (Exception ex) {
            System.out.println("Файл не найден");
        }  
    }
    
    public void readFile(String file) {
        try (FileReader reader = new FileReader(file)) {
            CharBuffer target = CharBuffer.allocate(1000);
            int length = reader.read(target);
            for(int i = 0; i < length; i++)
            {
                System.out.print(target.get(i));
            }
            
        } catch (Exception ex) {
            System.out.println("Файл не найден");
        }  
    }
    
 
    
}
