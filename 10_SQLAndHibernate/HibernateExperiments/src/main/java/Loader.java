import org.hibernate.Session;

public class Loader {
    public static void main(String[] args) {

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            Student student = session.get(Student.class, 2);
            Teacher teacher = session.get(Teacher.class, 1);
            Course courseNew = new Course("Basic Assembly language", 10, CourseType.PROGRAMMING,
                    "Такого еще не было", 99,65000,6500);
            courseNew.addTeacher(teacher);

            session.getTransaction().begin();

            session.save(courseNew);
            session.save(new NotificationStudentWork(student, teacher, "Do everything", "Work number one"));
            session.save(new NotificationTeacherAddCourse(courseNew, teacher, "You have a new course added", "New course"));
            session.save(new NotificationStudComment(student, teacher, "Explain the third example", "Work number two"));

            session.getTransaction().commit();

            session.clear();

            NotificationStudentWork n1 = session.get(NotificationStudentWork.class,1);
            NotificationTeacherAddCourse n2 = session.get(NotificationTeacherAddCourse.class,1);
            NotificationStudComment n3 = session.get(NotificationStudComment.class,1);

            System.out.println("\nTitle: " + n1.getTitle() + "\n" + "Message: " + n1.getMessage() + "\n"
                    + "Teacher: " + n1.getTeacher().getName() + "\n" + "Student: " + n1.getStudent().getName());

            System.out.println("\nTitle: " + n2.getTitle() + "\n" + "Message: " + n2.getMessage() + "\n"
                    + "Teacher: " + n2.getTeacher().getName() + "\n" + "Course: " + n2.getCourse().getName());

            System.out.println("\nTitle: " + n3.getTitle() + "\n" + "Message: " + n3.getMessage()
                    + "\n" + "Teacher: " + n3.getTeacher().getName() + "\n" + "Student: " + n3.getStudent().getName());



        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.shutDown();
        }
    }
}
