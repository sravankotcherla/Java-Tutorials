package Studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementDb {
    private static int id = 1000;
    private ArrayList<Student> students;

    public StudentManagementDb() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String gender, int year) {
        Student newStudent = new Student(id++ + "", name, age, gender, year);
        students.add(newStudent);
        System.out.println("Student added Successfully");
        newStudent.printInfo();
    }

    public void printAllStudents() {
        System.out.println("\n \n ----- Students List ------ \n");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("\n ----- End ------ \n \n");
    }

    public Student searchStudent(String searchTerm) {
        for (Student student : students) {
            if (searchTerm.equals(student.getID()) || searchTerm.compareToIgnoreCase(student.getName()) == 0) {
                return student;
            }
        }
        System.err.println("Can't find student with name/ID containing" + searchTerm);
        return null;
    }
    
    public void removeStudent(String ID) {
        Student reqStudent = searchStudent(ID);
        if (reqStudent == null) {
            System.out.println("No student found with ID : " + ID);
        } else {
            students.remove(reqStudent);
            System.out.println("Student removed successfully");
        }

    }

    public void modifyStudent(String searchTerm) {
        Student reqStudent = searchStudent(searchTerm);
        if (reqStudent == null) {
            System.out.println("No student found with ID/name : " + searchTerm);
        } else {
            Scanner studentScanner = new Scanner(System.in);
            
            boolean exitModifyLoop = false;
            while (!exitModifyLoop) {
                System.out.println("Choose an option to select the field to modify : ");
                System.out.println("1.Name 2.Age 3.Gender 4.Year 5.Exit");
                int option = studentScanner.nextInt();
                studentScanner.nextLine();
                if (option == 5) {
                    exitModifyLoop = true;
                } else {
                    System.out.println("Enter new value for the field :");
                    String newVal = studentScanner.nextLine();
                    reqStudent.modifyData(option, newVal);
                    System.out.println("Student modified successfully");
                    reqStudent.printInfo();
                }
            }
            // studentScanner.close();
        }
    }
}
