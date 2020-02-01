package mysq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author David Yang
 * @date 2019-10-10 17:29
 */
public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC", args[0], args[1], args[2]);
        Connection conn = DriverManager.getConnection(url,"root","passw0rd");
        if (conn != null) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }
}
