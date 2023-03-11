package com.person.daoimpl.person;

import com.person.dao.person.PersonDao;
import com.person.pojo.Emp;
import com.person.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张天旭
 * 员工管理 - 数据库操作：接口实现类
 * @date 2022/6/22 11:32
 */
public class PersonDaoImpl implements PersonDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 根据员工号查询一条信息
     *
     * @param empId 员工id
     * @return 员工对象
     */
    @Override
    public Emp selectEmpOne(int empId) {
        Emp emp = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "select * from emp where empId = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, empId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("empid");
                String name = resultSet.getString("empname");
                String sex = resultSet.getString("empsex");
                int age = resultSet.getInt("empage");
                int workyear = resultSet.getInt("work_year");
                String tele = resultSet.getString("telephone");
                String address = resultSet.getString("address");

                emp = new Emp(resultSet.getInt("empid"), resultSet.getString("empname"));
                emp.setEmpId(id);
                emp.setEmpName(name);
                emp.setEmpsex(sex);
                emp.setEmpage(age);
                emp.setWork_year(workyear);
                emp.setTelephone(tele);
                emp.setAddress(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;

    }

    /**
     * 查询所有的员工信息
     *
     * @return 员工对象集合
     */
    @Override
    public List<Emp> selectEmpAll() {
        List<Emp> empList = new ArrayList<>();

        try {
            connection = DbUtils.getConnection();
            String sql = "select * from emp;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("empid");
                String name = resultSet.getString("empname");
                String sex = resultSet.getString("empsex");
                int age = resultSet.getInt("empage");
                int workyear = resultSet.getInt("work_year");
                String tele = resultSet.getString("telephone");
                String address = resultSet.getString("address");

                Emp emp = new Emp(resultSet.getInt("empid"), resultSet.getString("empname"));
                emp.setEmpId(id);
                emp.setEmpName(name);
                emp.setEmpsex(sex);
                emp.setEmpage(age);
                emp.setWork_year(workyear);
                emp.setTelephone(tele);
                emp.setAddress(address);

                empList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empList;
    }

    /**
     * 根据员工号修改员工信息
     *
     * @param emp   修改后的员工对象
     * @param empId 员工号
     * @return 返回状态 1表示修改成功 0表示修改失败
     */
    @Override
    public int update(Emp emp, int empId) {
        int state = 0;
        try {
            connection = DbUtils.getConnection();
            String sql = "update emp set empname = ?, empsex = ?, empage = ?, work_year = ?, telephone = ?, address = ? where empid = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,emp.getEmpName());
            preparedStatement.setObject(2,emp.getEmpsex());
            preparedStatement.setObject(3,emp.getEmpage());
            preparedStatement.setObject(4,emp.getWork_year());
            preparedStatement.setObject(5,emp.getTelephone());
            preparedStatement.setObject(6,emp.getAddress());
            preparedStatement.setObject(7,emp.getEmpId());
            // i 表示修改成功的行数
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                state = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

    /**
     * 根据empId删除指定员工信息
     *
     * @param empId 员工id
     * @return 1表示删除成功 0表示删除失败
     */
    @Override
    public int deleteOne(int empId) {
        int state = 0;
        try {
            connection = DbUtils.getConnection();
            String sql1 = "delete from salary where empid = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1,empId);
            int result1 = preparedStatement.executeUpdate();
            if (result1 > 0){
                String sql2 = "delete from checking where empid = ?";
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1,empId);
                int result2 = preparedStatement.executeUpdate();
                if (result2 > 0){
                    String sql = "delete from emp where empid = ?;";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setObject(1, empId);

                    // i 表示修改成功的行数
                    int i = preparedStatement.executeUpdate();
                    if (i > 0) {
                        state = 1;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

    /**
     * 新增一条员工信息
     *
     * @param emp
     * @return 1表示插入成功 0表示插入失败
     */
    @Override
    public int insert(Emp emp) {
        int state = 0;
        try {
            connection = DbUtils.getConnection();
            String sql = "insert into emp(empname,empsex,empage,work_year,telephone,address) values(?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,emp.getEmpName());
            preparedStatement.setObject(2,emp.getEmpsex());
            preparedStatement.setObject(3,emp.getEmpage());
            preparedStatement.setObject(4,emp.getWork_year());
            preparedStatement.setObject(5,emp.getTelephone());
            preparedStatement.setObject(6,emp.getAddress());
            // i 表示修改成功的行数
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                state = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

    /**
     * 删除所有员工
     * @return 返回影响行数
     */
    @Override
    public int deleteAll() {
        int state = 0;
        try {
            connection = DbUtils.getConnection();
            String sql1 = "select emp.empid from emp,checking,salary where emp.empid = checking.empid and emp.empid = salary.empid";
            preparedStatement = connection.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("empid");
                String sql2 = "delete from checking where empid = ?";
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1,id);
                int i = preparedStatement.executeUpdate();
                if (i > 0){
                    System.out.println("checking-删除成功");
                }
                String sql3 = "delete from salary where empid = ?";
                preparedStatement = connection.prepareStatement(sql3);
                preparedStatement.setInt(1,id);
                int i2 = preparedStatement.executeUpdate();
                if (i2 > 0){
                    System.out.println("salary-删除成功");
                }
            }
            String sql = "delete from emp";
            preparedStatement = connection.prepareStatement(sql);
            // i 表示修改成功的行数
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                state = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

}
