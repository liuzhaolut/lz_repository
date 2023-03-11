package druid.connection.pool;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPool {
    public static void main(String[] args) throws SQLException {
        for (int i = 1; i <=20 ; i++) {
            Connection connection = DbUtils.getConnection();
            System.out.println(connection);
//            关闭--放回池中
            connection.close();
        }
    }
}
