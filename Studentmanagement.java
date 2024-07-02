import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course;
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student");
        System.out.println("4. View Students");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private void addStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, course));
        System.out.println("Student added.");
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new course: ");
                String course = scanner.nextLine();

                student.setName(name);
                student.setCourse(course);
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void viewStudents() {
        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
