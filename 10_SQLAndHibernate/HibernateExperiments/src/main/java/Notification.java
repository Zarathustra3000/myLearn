import javax.persistence.*;

@MappedSuperclass
public abstract class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id",nullable = false, columnDefinition = "int unsigned")
    private Teacher teacher;
    private String message;
    private String title;

    public Notification(Teacher teacher, String message, String title) {
        this.teacher = teacher;
        this.message = message;
        this.title = title;
    }

    public Notification() {
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
