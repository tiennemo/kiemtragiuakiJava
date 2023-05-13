package kiemtragiuaki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try {
            // Mở tệp input.txt để đọc
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            // Tạo một ArrayList để lưu các đối tượng
            ArrayList<Employee> employees = new ArrayList<>();

            // Đọc từng dòng trong tệp và tạo đối tượng Employee tương ứng
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1].split(": ")[0]);
                String city = parts[2];
                double salary = Double.parseDouble(parts[3].replaceAll("\\.", ""));
                employees.add(new Employee(name, age, city, salary));
            }

            // Đóng tệp
            scanner.close();

            // Hiển thị danh sách các đối tượng
            System.out.println("Danh sách các đối tượng:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }

            // Sắp xếp theo lương tăng dần
            Collections.sort(employees, Comparator.comparing(Employee::getSalary));

            // Hiển thị lương cao nhất
            System.out.println("Lương cao nhất:");
            System.out.println(employees.get(employees.size() - 1));
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin.");
        }
    }
}

	class Employee {
    private String name;
    private int age;
    private String city;
    private double salary;

    public Employee(String name, int age, String city, double salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + age + " tuổi - " + city + " - " + String.format("%,.0f", salary) + " đồng";
    }
}
