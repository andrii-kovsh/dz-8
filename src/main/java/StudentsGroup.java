import java.util.ArrayList;
import java.util.List;

public class StudentsGroup {
    private Student groupLeader;
    private final List<Student> students;
    private final List<String> tasks;

    public StudentsGroup(Student groupLeader) {
        this.groupLeader = null;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        setGroupLeader(groupLeader);
    }

    public void changeGroupLeader(Student newGroupLeader) {
        setGroupLeader(newGroupLeader);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String task) {
        // Логіка позначення завдання як виконаного для зазначеного студента
    }

    public boolean hasGroupLeader() {
        return groupLeader != null;
    }

    private void setGroupLeader(Student newGroupLeader) {
        if (newGroupLeader != null) {
            this.groupLeader = newGroupLeader;
        }
    }

    public void displayGroupDetails() {
        System.out.println("Староста: " + groupLeader.getFirstName() + " " + groupLeader.getLastName());
        System.out.println("Студенти:");
        for (Student student : students) {
            System.out.println("- " + student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")");
        }
        System.out.println("Задачі:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
}