package CognologixTask;
import java.util.*;

public class Problem1 {

    class StudentData {
        int studentId, marks;
        String subject;

        public StudentData(int studentId, String subject, int marks) {
            this.studentId = studentId;
            this.subject = subject;
            this.marks = marks;
        }
    }

    // add raw data
    private void addRawData(List<StudentData> data) {
        data.add(new StudentData(22, "Data Structures", 45));
        data.add(new StudentData(23, "English", 52));
        data.add(new StudentData(22, "English", 51));
        data.add(new StudentData(26, "Data Structures", 72));
        data.add(new StudentData(23, "Data Structures", 61));
        data.add(new StudentData(24, "English", 81));
    }

    public int averageMarks() {
        List<StudentData> data = new ArrayList<>();
        addRawData(data);

        // find minimum id
        int minimumStudentId = Integer.MAX_VALUE, index = 0;
        for (StudentData student : data) {
            if (student.studentId < minimumStudentId) {
                minimumStudentId = student.studentId;
            }
        }

        int ans = 0, count = 0;
        for (StudentData student : data) {
            if (student.studentId == minimumStudentId) {
                ans += student.marks;
                count++;
            }
        }
        return ans / count;
    }

    public static void main(String[] args) {
        Problem1 o = new Problem1();
        System.out.println(o.averageMarks());
    }
}
