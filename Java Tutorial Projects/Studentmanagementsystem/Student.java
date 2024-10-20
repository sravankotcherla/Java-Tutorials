package Studentmanagementsystem;

public class Student {
    private final String ID;
    private String name;
    private int age;
    private String gender;
    private int year;

    public Student(String ID, String name, int age, String Gender, int year) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = Gender;
        this.year = year;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println("\nName: " + name + "\nAge : " + age + "\nGender : " + gender + "\nYear : " + year);
    }

    @Override
    public String toString() {
        return name + "  " + age + "  " + gender + "  " + year + "\n";
    }

    public void modifyData(int fieldNumber, String newVal){
        switch(fieldNumber) {
            case 1:
                name = newVal;
                break;
            case 2:
                age = Integer.parseInt(newVal);
                break;
            case 3:
                gender = newVal;
                break;
            case 4:
                year = Integer.parseInt(newVal);
                break;
            case 5:
                System.out.println("Invalid Option. Please Try again ...");
                break;
        }
    }
}
