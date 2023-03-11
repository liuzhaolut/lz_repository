package com.person.daoimpl.checking;

import com.person.dao.checking.ApplyDao;
import com.person.pojo.Apply;
import com.person.pojo.Checking;
import com.person.util.DaoUtils;
import com.person.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - 数据库操作：请假单实现类
 * @date 2022/6/25
 */
public class ApplyDaoImpl extends DaoUtils implements ApplyDao {
    /**
     * 通过部门名称，员工名称获取用户id
     * @param depName 部门名字
     * @param empName 员工名字
     * @return  员工id
     */
    @Override
    public Integer getCheckId(String depName, String empName) {
        String sql = "select check_id from checking where empname = ? and depname = ?;";
        Object[] objects = {empName,depName};
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql,objects);
            if (resultSet.next()) {
                Integer check_id = resultSet.getInt("check_id");
                return check_id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null,null, resultSet);
        }
        return null;
    }

    /**
     * 新增请假信息
     * @param apply 请假信息
     * @return 返回是否新增成功
     */
    @Override
    public boolean addApply(Apply apply) {
        boolean result = false;
        String sql = "INSERT INTO `person`.`apply`(`now_date`, `check_id`, `comment_c`, `begin_date`, `end_date`, `comment_d`, `comment_z`,count) VALUES ( ?, ?, ?, ?, ?, ?, ?,?);";
        Object[] objects = {apply.getNowDate(),apply.getCheckId(),apply.getCommentC(),apply.getBeginDate(),apply.getEndDate(),apply.getCommentD(),apply.getCommentZ(),apply.getCount()};
        try {
            int insert = this.exeUpdate(sql,objects);
            if (insert > 0){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取所有请假单
     * @return 返回所有请假信息
     */
    @Override
    public List<Apply> getApplyAll() {
        List<Apply> applies= new ArrayList<>();;
        String sql = "select * from apply;";
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql,null);
            while (resultSet.next()) {
                Date now_date = resultSet.getDate("now_date");
                Date begin_date = resultSet.getDate("begin_date");
                Date end_date = resultSet.getDate("end_date");
                int cId = resultSet.getInt("check_id");
                int aId = resultSet.getInt("a_id");
                int count = resultSet.getInt("count");
                String comment_c = resultSet.getString("comment_c");
                String comment_d = resultSet.getString("comment_d");
                String comment_z = resultSet.getString("comment_z");
                Apply apply = new Apply(aId,now_date,cId,comment_c,comment_z,comment_d,begin_date,end_date,count);
                applies.add(apply);
            }
            return applies;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null,null, resultSet);
        }
        return null;
    }

    /**
     * 查询有无此请假单
     * @param parseInt 请假单id
     * @return 返回请假单信息
     */
    @Override
    public Apply selectOneApply(int parseInt) {
        String sql = "select * from apply where a_id = ?";
        Object[] objects = {parseInt};
        ResultSet resultSet = null;
        try {
            resultSet = this.exeQuery(sql,objects);
            if (resultSet.next()) {
                Date now_date = resultSet.getDate("now_date");
                Date begin_date = resultSet.getDate("begin_date");
                Date end_date = resultSet.getDate("end_date");
                int cId = resultSet.getInt("check_id");
                int aId = resultSet.getInt("a_id");
                int count = resultSet.getInt("count");
                String comment_c = resultSet.getString("comment_c");
                String comment_d = resultSet.getString("comment_d");
                String comment_z = resultSet.getString("comment_z");
                Apply apply = new Apply(aId,now_date,cId,comment_c,comment_z,comment_d,begin_date,end_date,count);
                return apply;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.close(null,null, resultSet);
        }
        return null;
    }

    /**
     * 删除此请假单
     * @param parseInt 请假单id
     * @return 返回是否删除成功
     */
    @Override
    public boolean deleteApply(int parseInt) {
        boolean result = false;
        String sql = "delete from apply where a_id = ?";
        Object[] objects = {parseInt};
        try {
            int insert = this.exeUpdate(sql,objects);
            if (insert > 0){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
