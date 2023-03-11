package com.person.dao.person;

import com.person.pojo.Emp;

import java.util.List;

/**
 * @author 张天旭
 * 员工管理 - 数据库操作：接口层
 * @date 2022/6/22 11:32
 */
public interface PersonDao {

    /**
     * 根据员工号查询一条信息
     * @param empId 员工id
     * @return 员工对象
     */
    public Emp selectEmpOne(int empId);

    /**
     * 查询所有的员工信息
     * @return 员工对象集合
     */
    public List<Emp> selectEmpAll();

    /**
     * 根据员工号修改员工信息
     * @param emp 修改后的员工对象
     * @param empId 员工号
     * @return 返回状态 1表示修改成功 0表示修改失败
     */
    public int update(Emp emp, int empId);

    /**
     * 根据empId删除指定员工信息
     * @param empId 员工id
     * @return 1表示删除成功 0表示删除失败
     */
    public int deleteOne(int empId);

    /**
     * 新增一条员工信息
     * @param emp
     * @return 1表示插入成功 0表示插入失败
     */
    public int insert(Emp emp);

    /**
     * 删除所有员工
     * @return 返回影响行数
     */
    int deleteAll();
}
