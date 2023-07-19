import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsGroup {
    private final Student groupLeader;
    private final List<Student> students;
    private final Map<String, Student> completedTasks;
    private final List<String> tasks;

    public StudentsGroup(Student groupLeader) {
        this.groupLeader = groupLeader;
        this.students = new ArrayList<>();
        this.completedTasks = new HashMap<>();
        this.tasks = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String task) {
        if (students.contains(student) && tasks.contains(task)) {
            completedTasks.put(task, student);
        }
    }

    public void displayGroupDetails() {
        System.out.println("Староста групи: " + groupLeader.getFirstName() + " " + groupLeader.getLastName());
        System.out.println("Список студентів:");
        for (Student student : students) {
            System.out.println("- " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void displayCompletedTasks() {
        System.out.println("Виконані завдання:");
        for (String task : tasks) {
            if (completedTasks.containsKey(task)) {
                Student student = completedTasks.get(task);
                System.out.println("- " + task + ": Виконано студентом " + student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    public void displayNotCompletedTasks() {
        System.out.println("Невиконані завдання:");
        for (String task : tasks) {
            if (!completedTasks.containsKey(task)) {
                System.out.println("- " + task);
            }
        }
    }
}