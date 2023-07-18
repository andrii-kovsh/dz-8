import java.util.ArrayList;
import java.util.List;

public class StudentsGroup {
    private Student groupLeader;
    private final List<Student> students;
    private final List<String> tasks;
    private final List<Boolean> taskStatus;

    public StudentsGroup(Student groupLeader) {
        this.groupLeader = groupLeader;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.taskStatus = new ArrayList<>();
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
        taskStatus.add(false);
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
    }

    public void markTaskAsCompleted(Student student, String task) {
        int studentIndex = students.indexOf(student);
        int taskIndex = tasks.indexOf(task);
            if (studentIndex != -1 && taskIndex != -1) {
                taskStatus.set(taskIndex, true);
            }
    }

    public void displayCompletedTasks() { // Метод для виводу виконаних завдань і виконавця
        System.out.println("Виконані завдання:");
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            boolean status = taskStatus.get(i);
            if (status) {
                Student student = students.get(i);
                System.out.println("- " + task + ": Виконано студентом " + student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    public void displayNotCompletedTasks() { // Метод для виводу невиконаних завдань
        System.out.println("Не виконані завдання:");
        boolean allTasksCompleted = true; // Змінна для визначення, чи всі завдання виконані

        for (int i = 0; i < tasks.size(); i++) {
            if (!taskStatus.get(i)) {
                System.out.println("- \"" + tasks.get(i) + "\"");
                allTasksCompleted = false;
            }
        }

        if (allTasksCompleted) {
            System.out.println("Всі завдання виконані");
        }
    }
}