import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseListPK implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false, columnDefinition = "int unsigned")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, columnDefinition = "int unsigned")
    private Course course;

    public PurchaseListPK() {
    }

    public PurchaseListPK(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseListPK that = (PurchaseListPK) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}
