import org.hibernate.Session;

public class Loader {
    public static void main(String[] args) {

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            Course course = session.get(Course.class, 1);
            System.out.println(course.getName());

            Student student = session.get(Student.class, 1);
            System.out.println(student.getName());

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.shutDown();
        }
    }
}
