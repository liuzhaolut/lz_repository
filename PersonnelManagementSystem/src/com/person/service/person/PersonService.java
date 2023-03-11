package com.person.service.person;

import com.person.pojo.Emp;

import java.util.List;

/**
 * @author 张天旭
 * 员工管理 - 逻辑控制：接口层
 * @date 2022/6/22 11:32
 */
public interface PersonService {
    /**
     * 通过员工号查询一个员工信息
      * @param empId 员工号
     * @return 员工对象
     */
    public Emp selectEmpOneService(int empId);

    /**
     * 查询所有员工信息
     * @return 员工对象的集合
     */
    public List<Emp> selectEmpAllService();

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
     * 删除所有员工信息
     * @return 返回受影响的行数
     */
    int deleteAll();
}
