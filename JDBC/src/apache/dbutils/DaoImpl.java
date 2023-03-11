package apache.dbutils;

import com.jdbc.anli.DButils;
import druid.connection.pool.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao的实现类
 * @author lz
 */
public class DaoImpl implements Dao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

    @Override
    public int addUser(User user) {
        Object[] params = {user.getUsername(),user.getPassword(),user.getAddress(),user.getPhone(),user.getCreatedate()};
        int result = 0;
        try {
            result = queryRunner.update("insert into user(username,password,address,phone,createdate) values(?,?,?,?,?)",params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteUser(User user) {
        Object[] params = {user.getUsername()};
        int result = 0;
        try {
            result = queryRunner.update("delete from user where username = ?;",params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        Object[] params = {user.getPassword(),user.getAddress(),user.getPhone(),user.getUsername()};
        int result = 0;
        try {
            result = queryRunner.update("update user set password = ?,address = ?,phone = ? where username = ?",params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public User selectOne(User user) {
        Object[] params = {user.getUsername()};
        User user1 = null;
        try {
            user1 = queryRunner.query("select * from user where username = ?;",new BeanHandler<User>(User.class),params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user1;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = null;
        try {
            users = queryRunner.query("select * from user;",new BeanListHandler<User>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public long selectUserNum() {
        long l = 0;
        try {
            l = queryRunner.query("select count(*) from user;",new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return l;
    }
}
