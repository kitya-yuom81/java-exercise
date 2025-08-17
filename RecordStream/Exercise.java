package RecordStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise {
    record Student(String name, String course, int score) {}
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", "Math", 85),
                new Student("Bob", "Science", 72),
                new Student("Charlie", "Math", 45),
                new Student("Diana", "History", 90),
                new Student("Eve", "Science", 60),
                new Student("Frank", "History", 30),
                new Student("Grace", "Math", 95)
        );
        System.out.println("All students:");
        students.forEach(System.out::println);

        double avgScore = students.stream()
                .mapToInt(Student::score)
                .average()
                .orElse(0.0);
        System.out.println("Avg score: " + avgScore);

        System.out.println("\nTop 3 Students:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::score).reversed())
                .limit(3)
                .forEach(System.out::println);
        System.out.println("\nStudents Grouped by Course:");
        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(Student::course));
        grouped.forEach((course, group) -> {
            System.out.println(course + " -> " + group);
        });
        boolean hasFailed = students.stream()
                .anyMatch(s -> s.score() < 50);
        System.out.println("\nAny student failed? " + hasFailed);





    }
}
