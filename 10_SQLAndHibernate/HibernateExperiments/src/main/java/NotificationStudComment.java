import javax.persistence.*;

@Entity
public class NotificationStudComment extends Notification {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false, columnDefinition = "int unsigned")
    private Student student;

    public NotificationStudComment(Student student, Teacher teacher, String message, String title) {
        super(teacher, message, title);
        this.student = student;
    }

    public NotificationStudComment() {
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
