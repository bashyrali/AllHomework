import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeColection {
    List<String> lines = new ArrayList<String>();
    public void toList(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(" ");
                if (index == -1) {
                    
                } else {
                    String name = line.substring(0, index+5);
                    lines.add(name);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getEmploy(String search) {
        String[] collect = new String[4];
        for (String s : lines) {
            if (s.contains(search)) {
                return s;
            }
            
        }
        return null;
    }
}
