package prog.assignment;

public class Student {

    private int studID;
    private String studName;
    private int age;
    private String studEmail;
    private String stdCourse;

    // Constructor
    public Student(int id, String name, int age, String email, String course) {
        this.studID = id;
        this.studName = name;
        this.age = age;
        this.studEmail = email;
        this.stdCourse = course;
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getSTDCourse() {
        return stdCourse;
    }

    public void setSTDCourse(String stdCourse) {
        this.stdCourse = stdCourse;
    }

    public void printStudentReport() {
        System.out.println("\nStudent ID: " + studID);
        System.out.println("Student Name: " + studName);
        System.out.println("Student Age: " + age);
        System.out.println("Student Email: " + studEmail);
        System.out.println("Student Course: " + stdCourse);
        System.out.println("\n");
    }
}
