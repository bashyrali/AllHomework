import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathname = "C:\"";
        String filename = "input.txt";
        String out = "out.txt";
        EmployeeColection employeeColection = new EmployeeColection();
        Employee employee = new Employee(pathname, filename);
        employee.readFile(filename);
        employeeColection.toList(filename);
        System.out.println(employeeColection.lines);
        System.out.println("Enter position:");
        String position = System.console().readLine();
        for (String s : employeeColection.lines) {
            if (s.contains(position)) {
                employee.appendToFile(out,s );
            }
            
        }
        employee.readFile(out);

    }

}
