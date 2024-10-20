package Studentmanagementsystem;

import java.util.Scanner;

public class Studentmanagementsystem {
    @SuppressWarnings("finally")
    public static void main(String[] args){
        System.out.println("SMS !!!!");

        StudentManagementDb sms = new StudentManagementDb();
        Scanner scanner = new Scanner(System.in);
        boolean exitLoop=false;
        while(!exitLoop){
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Search Student by ID or Name");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Name : ");
                    String name = scanner.nextLine();
                    System.out.println("Age : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Gender : ");
                    String gender = scanner.nextLine();
                    System.out.println("Year : ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    sms.addStudent(name, age, gender, year);
                    break;
                case 2:
                    System.out.println("Enter ID of the student to remove : ");
                    String ID = scanner.nextLine();
                    sms.removeStudent(ID);
                    break;
                case 3:
                    System.out.println("Enter ID or name of the student : ");
                    String search=scanner.nextLine();;
                    sms.modifyStudent(search);
                    break;
                case 4:
                    sms.printAllStudents();
                    break;
                case 5:
                    try {
                        System.out.println("Enter ID or name to search : ");
                        String searchTerm= scanner.nextLine();
                        sms.searchStudent(searchTerm).printInfo();
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 6:
                    exitLoop=true;
                    scanner.close();
                    break;
            }
        }
    }
}
