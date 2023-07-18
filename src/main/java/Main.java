public class Main {
    public static void main(String[] args) {
        Student groupLeader = new Student(1, "Василь", "Чірт");
        StudentsGroup studentsGroup = new StudentsGroup(groupLeader);
        Student student1 = new Student(2, "Петро", "Попадайло");
        Student student2 = new Student(3, "Іра", "Дика");
        Student student3 = new Student(4, "Алла", "Бараболя");

        studentsGroup.addStudent(groupLeader);
        studentsGroup.addStudent(student1);
        studentsGroup.addStudent(student2);
        studentsGroup.addStudent(student3);

        studentsGroup.addTask("Не наткнутись на виключення в коді");
        studentsGroup.addTask("Вивчити цикли: for, while, for each");

        studentsGroup.displayGroupDetails();
    }
}