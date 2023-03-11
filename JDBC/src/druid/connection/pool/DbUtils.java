package druid.connection.pool;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {
//    声明一个连接池对象(确保程序使用的是同一个connection)
    private static DruidDataSource ds;
    static {
        Properties properties = new Properties();
        InputStream in = DbUtils.class.getResourceAsStream("/dbpool.properties");
        try {
            properties.load(in);
//            创建连接池连接
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
//            通过连接池获得连接对象
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
