import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

public class Loader {

    private static final String URL = "jdbc:mysql://localhost:3306/skillbox"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT PurchaseList.course_name, " +
                    "COUNT(*)/(TIMESTAMPDIFF(MONTH, MIN(PurchaseList.subscription_date), MAX(PurchaseList.subscription_date)))\n" +
                    "FROM PurchaseList\n" +
                    "GROUP BY PurchaseList.course_name;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(resultSet);
            DbUtils.close(statement);
            DbUtils.close(connection);
        }

    }
}
