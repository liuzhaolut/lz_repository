package com.person.daoimpl.checking;

import com.person.dao.checking.CheckingDao;
import com.person.pojo.Checking;
import com.person.pojo.Emp;
import com.person.util.DaoUtils;
import com.person.util.DateUtils;
import com.person.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - 数据库操作：考勤实现类
 * @date 2022/6/25
 */
public class CheckingDaoImpl extends DaoUtils implements CheckingDao {
    /**
     * 通过ID查询有无此用户
     * @param id 员工id
     * @return 返回员工信息
     */
    @Override
    public Emp selectOneEmp(int id) {
        Object[] objects = {id};
        String sql = "select * from emp where empid = ?;";
        ResultSet resultSet = null;
        try {
            resultSet = super.exeQuery(sql, objects);
            if (resultSet.next()) {
                Emp emp = new Emp(resultSet.getInt("empid"),
                        resultSet.getString("empname"));
                return emp;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return null;
    }

    /**
     * 新增考勤记录
     * @param checking 考勤信息
     * @return 返回新增是否成功
     */
    @Override
    public boolean insertChecking(Checking checking) {
        boolean result = false;
        String sql = "INSERT INTO `person`.`checking`(`empid`, `empname`, `depname`, `start_time`, `state`, `note`) VALUES (?, ?, ?, ?, ?, ?);";
        Object[] objects = {checking.getEmpId(), checking.getEmpName(), checking.getDepName(), checking.getStartDate(), checking.getState(), checking.getNote()};
        try {
            int insert = this.exeUpdate(sql, objects);
            System.out.println(result);
            if (insert > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询所欲考勤信息
     * @return 返回所有考勤信息
     */
    @Override
    public List<Checking> selectCheckingAll() {
        List<Checking> list = new ArrayList<>();
        ;
        String sql = "select * from checking;";
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql, null);
            while (resultSet.next()) {
                Integer checkId = resultSet.getInt("check_id");
                Integer empId = resultSet.getInt("empid");
                String empname = resultSet.getString("empname");
                String depname = resultSet.getString("depname");
                Date time = resultSet.getDate("start_time");
                Integer state = resultSet.getInt("state");
                String note = resultSet.getString("note");
                Checking checking = new Checking(checkId, empId, empname, depname, time, state, note);
                list.add(checking);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return null;
    }

    /**
     * 通过ID删除对应考勤记录
     * @param checking 考勤id
     * @return 返回是否删除成功
     */
    @Override
    public boolean deleteChecking(Checking checking) {
        boolean delete = false;
        String sql = "delete from checking where check_id =?;";
        Object[] objects = {checking.getCheckId()};
        try {
            int result = this.exeUpdate(sql, objects);
            if (result > 0) {
                delete = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }

    /**
     * 查询单条考勤记录
     * @param parseInt 考勤id
     * @return 返回考勤信息
     */
    @Override
    public Checking selectOneChecking(int parseInt) {
        String sql = "select * from checking where check_id = ?;";
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql, parseInt);
            if (resultSet.next()) {
                Integer checkId = resultSet.getInt("check_id");
                Integer empId = resultSet.getInt("empid");
                String empname = resultSet.getString("empname");
                String depname = resultSet.getString("depname");
                Date time = resultSet.getDate("start_time");
                Integer state = resultSet.getInt("state");
                String note = resultSet.getString("note");
                Checking checking = new Checking(checkId, empId, empname, depname, time, state, note);
                return checking;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return null;
    }

    /**
     * 修改考勤记录
     * @param checking 考勤信息
     * @return 返回是否修改成功
     */
    @Override
    public boolean updateChecking(Checking checking) {
        boolean result = false;
        String sql = "UPDATE `person`.`checking` SET  `depname` = ?, `start_time` = ?, `state` = ?, `note` = ? WHERE `check_id` = ?;";
        Object[] objects = {checking.getDepName(), checking.getStartDate(), checking.getState(), checking.getNote(), checking.getCheckId()};
        try {
            int update = this.exeUpdate(sql, objects);
            if (update > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询
     * @param key 模糊查询
     * @return 返回模糊查询的结果
     */
    @Override
    public List<Checking> searchChecking(String key) {
        List<Checking> list = new ArrayList<>();
        ;
        String sql = "select * from checking where empname like ?;";
        Object[] objects = {key};
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql, objects);
            while (resultSet.next()) {
                Integer checkId = resultSet.getInt("check_id");
                Integer empId = resultSet.getInt("empid");
                String empname = resultSet.getString("empname");
                String depname = resultSet.getString("depname");
                Date time = resultSet.getDate("start_time");
                Integer state = resultSet.getInt("state");
                String note = resultSet.getString("note");
                Checking checking = new Checking(checkId, empId, empname, depname, time, state, note);
                list.add(checking);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return null;
    }

    /**
     * 模糊查询查询有无员工
     * @param key 模糊查询的key
     * @return 饭后是否有此员工
     */
    @Override
    public boolean selectNameEmp(String key) {
        boolean flag = false;
        Object[] objects = {key};
        String sql = "select empid from emp where empname like ?;";
        ResultSet resultSet = null;
        try {
            resultSet = super.exeQuery(sql, objects);
            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpId(resultSet.getInt("empid"));
                if (emp.getEmpId() != null) {
                    flag = true;
                }

            }
            return flag;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return flag;
    }

    /**
     * @param parseInt 考勤id
     * @param empName 员工姓名
     * @return 返回查询到的员工信息
     */
    @Override
    public Emp selectEmpId(int parseInt, String empName) {
        Object[] objects = {empName, parseInt};
        String sql = "select * from emp where empname = ? and empid = ?;";
        Emp emp = new Emp();
        ResultSet resultSet = null;
        try {
            resultSet = super.exeQuery(sql, objects);
            if (resultSet.next()) {
                emp.setEmpId(resultSet.getInt("empid"));
                emp.setEmpName(resultSet.getString("empname"));
            }
            return emp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null, null, resultSet);
        }
        return emp;
    }
}
