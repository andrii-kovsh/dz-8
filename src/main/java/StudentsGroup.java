import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsGroup {
    private Student groupLeader;
    private final List<Student> students;
    private final Map<String, List<Student>> completedTasks;
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

    private void setGroupLeader(Student newGroupLeader) {
        if (newGroupLeader == null)
            throw new RuntimeException("Group leader can't be null");
        this.groupLeader = newGroupLeader;
        if (!students.contains(newGroupLeader))
            students.add(newGroupLeader);
    }


    public void removeStudent(Student student) {
        if (student != null) {
            if (student.equals(groupLeader)) {
                System.out.println("Старосту групи не можна видалити!");
                return;
            }

            students.remove(student);
            // При видаленні студента також видаляємо його з виконаних завдань
            for (List<Student> studentsList : completedTasks.values()) {
                studentsList.remove(student);
            }
        }
    }

    public void markTaskAsCompleted(Student student, String task) {
        if (students.contains(student) && tasks.contains(task)) {
            completedTasks.computeIfAbsent(task, key -> new ArrayList<>()).add(student);
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
        for (Map.Entry<String, List<Student>> entry : completedTasks.entrySet()) {
            String task = entry.getKey();
            List<Student> studentsList = entry.getValue();
            System.out.print("- " + task + ": Виконано студентами: ");
            for (Student student : studentsList) {
                System.out.print(student.getFirstName() + " " + student.getLastName() + ", ");
            }
            System.out.println();
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