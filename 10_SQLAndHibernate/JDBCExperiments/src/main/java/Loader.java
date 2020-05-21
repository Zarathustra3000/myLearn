import java.sql.*;

public class Loader {
    public static void main(String[] args) {

        // String url = myURL;

        // String user = "user";
        // String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT subscription_date FROM PurchaseList ORDER BY subscription_date");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("subscription_date"));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
