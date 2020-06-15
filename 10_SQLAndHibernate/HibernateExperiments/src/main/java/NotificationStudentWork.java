import javax.persistence.*;

@Entity
public class NotificationStudentWork extends Notification {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false, columnDefinition = "int unsigned")
    private Student student;

    public NotificationStudentWork(Student student, Teacher teacher, String message, String title) {
        super(teacher, message, title);
        this.student = student;
    }

    public NotificationStudentWork() {
        super();
    }


    public Teacher getTeacher() {
        return super.getTeacher();
    }


    public String getMessage() {
        return super.getMessage();
    }


    public String getTitle() {
        return super.getTitle();
    }

    public Student getStudent() {
        return student;
    }

}
