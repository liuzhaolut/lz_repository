package com.person.daoimpl.wage;

import com.person.dao.wage.WageDao;
import com.person.pojo.Emp;
import com.person.pojo.Salary;
import com.person.util.DaoUtils;
import com.person.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴洋洋
 * @date 2022/6/26 11:53
 */
public class WageDaoImpl extends DaoUtils implements WageDao {
    Connection connection = DbUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 查询所有工资信息
     * @return 返回所有工资信息
     */
    @Override
    public List<Salary> selectSalaryAll() {
        List<Salary> salaries = new ArrayList<>();
        String sql = "select * from salary;";
        Object[] objects = {};
        try {
            ResultSet rs = super.exeQuery(sql, objects);
            //遍历数据
            while (rs.next()) {
                int salids = rs.getInt("salid");
                int empId = rs.getInt("empid");
                String empName = rs.getString("empname");
                Double overtime = rs.getDouble("overtime");
                Double baseSal = rs.getDouble("base_sal");
                Double commission = rs.getDouble("commission");
                Double allSal = rs.getDouble("all_sal");
                Salary salary = new Salary(salids, empId, empName, overtime, baseSal, commission, allSal);
                salaries.add(salary);
            }
            System.out.println(salaries.size() + "----dao");
            return salaries;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询单个员工数据
     * @param empId 员工id
     * @return 返回员工信息
     */
    @Override
    public Salary selectSalaryId(int empId) {
        System.out.println(empId);
        String sql = "select * from salary where empid = ?";
        Object[] objects = {empId};
        try {
            ResultSet rs = super.exeQuery(sql, objects);
            //遍历数据 单个数据  集合用while
            if (rs.next()) {
                int salids = rs.getInt("salid");
                int empId1 = rs.getInt("empid");
                String empName = rs.getString("empname");
                Double overtime = rs.getDouble("overtime");
                Double baseSal = rs.getDouble("base_sal");
                Double commission = rs.getDouble("commission");
                Double allSal = rs.getDouble("all_sal");
                Salary salary = new Salary(salids, empId1, empName, overtime, baseSal, commission, allSal);
                return salary;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 删除员工薪资
     * @param id 工资id
     * @return 返回受影响行数
     */
    @Override
    public int deleteId(int id) {
        int result = 0;
        try {
            String sql = "delete from salary where salid = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入员工薪资
     * @param salary 员工薪资信息
     * @return 返回受影响行数
     */
    @Override
    public int inseretSaraly(Salary salary) {
        int result = 0;
       try {
           String sql = "insert into salary(empid,empname,overtime,base_sal,commission,all_sal) values(?,?,?,?,?,?);";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setObject(1,salary.getEmpId());
           preparedStatement.setObject(2,salary.getEmpName());
           preparedStatement.setObject(3,salary.getOvertime());
           preparedStatement.setObject(4,salary.getBaseSal());
           preparedStatement.setObject(5,salary.getCommission());
           preparedStatement.setObject(6,salary.getAllSal());
           result = preparedStatement.executeUpdate();
       }catch (Exception e){
           e.printStackTrace();
       }
      return  result;
    }

    /**
     * 修改
     *
     * @param salary 员工薪资信息
     * @return 返回是否修改成功
     */
    @Override
    public boolean UpSaraly(Salary salary) {
        boolean flag = false;
        connection = DbUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update salary set overtime=?,base_sal=?,commission=?,all_sal=? where salid = ?");
            preparedStatement.setDouble(1,salary.getOvertime());
            preparedStatement.setDouble(2,salary.getBaseSal());
            preparedStatement.setDouble(3,salary.getCommission());
            preparedStatement.setDouble(4,salary.getAllSal());
            preparedStatement.setInt(5,salary.getSalId());
            int e = preparedStatement.executeUpdate();
            if (e > 0) {
                System.out.println("e:" + e);
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改-回显
     * @param id 薪资id
     * @return 返回薪资信息
     */
    @Override
    public Salary getSalyId(int id) {
        try {
            connection = DbUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from salary where salid=?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Salary salary = new Salary(
                        resultSet.getInt("salid"),
                        resultSet.getInt("empid"),
                        resultSet.getString("empname"),
                        resultSet.getDouble("overtime"),
                        resultSet.getDouble("base_sal"),
                        resultSet.getDouble("commission"),
                        resultSet.getDouble("all_sal"));
                return  salary;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return  null;
    }
}