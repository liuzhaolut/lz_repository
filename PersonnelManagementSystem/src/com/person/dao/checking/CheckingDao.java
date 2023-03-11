package com.person.dao.checking;


import com.person.pojo.Checking;
import com.person.pojo.Emp;

import java.util.List;


/**
 * @author 刘昭
 * 考勤管理 - 数据库操作：考勤接口层
 * @date 2022/6/25
 */
public interface CheckingDao {
    /**
     * 通过ID查询有无此用户
     * @param id 员工id
     * @return 返回员工信息
     */
    Emp selectOneEmp(int id);

    /**
     * 新增考勤记录
     * @param checking 考勤信息
     * @return 返回新增是否成功
     */
    boolean insertChecking(Checking checking);

    /**
     * 查询所欲考勤信息
     * @return 返回所有考勤信息
     */
    List<Checking> selectCheckingAll();

    /**
     * 通过ID删除对应考勤记录
     * @param checking 考勤id
     * @return 返回是否删除成功
     */
    boolean deleteChecking(Checking checking);

    /**
     * 查询单条考勤记录
     * @param parseInt 考勤id
     * @return 返回考勤信息
     */
    Checking selectOneChecking(int parseInt);

    /**
     * 修改考勤记录
     * @param checking 考勤信息
     * @return 返回是否修改成功
     */
    boolean updateChecking(Checking checking);

    /**
     * 查询
     * @param key 模糊查询
     * @return 返回模糊查询的结果
     */
    List<Checking> searchChecking(String key);

    /**
     * 模糊查询查询有无员工
     * @param key 模糊查询的key
     * @return 饭后是否有此员工
     */
    boolean selectNameEmp(String key);

    /**
     * @param parseInt 考勤id
     * @param empName 员工姓名
     * @return 返回查询到的员工信息
     */
    Emp selectEmpId(int parseInt, String empName);
}
