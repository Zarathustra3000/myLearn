import javax.persistence.*;

@Entity
public class NotificationTeacherAddCourse extends Notification {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id",nullable = false, columnDefinition = "int unsigned")
    private Course course;

    public NotificationTeacherAddCourse(Course course, Teacher teacher, String message, String title) {
        super(teacher, message, title);
        this.course = course;
    }

    public NotificationTeacherAddCourse() {
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

    public Course getCourse() {
        return course;
    }
}
