package com.person.dao.wage;

import com.person.pojo.Emp;
import com.person.pojo.Salary;

import java.util.List;

/**
 * @author 吴洋洋
 * @date 2022/6/26 15:53
 */
public interface WageDao {

    /**
     * 查询所有工资信息
     * @return 返回所有工资信息
     */
    List<Salary> selectSalaryAll();

    /**
     * 查询单个员工数据
     * @param empId 员工id
     * @return 返回员工信息
     */
    Salary selectSalaryId(int empId);

    /**
     * 删除员工薪资
     * @param id 工资id
     * @return 返回受影响行数
     */
    int deleteId(int id);

    /**
     * 插入员工薪资
     * @param salary 员工薪资信息
     * @return 返回受影响行数
     */
    int inseretSaraly(Salary salary);

    /**
     * 修改
     *
     * @param salary 员工薪资信息
     * @return 返回是否修改成功
     */
    boolean UpSaraly(Salary salary);

    /**
     * 修改-回显
     * @param id 薪资id
     * @return 返回薪资信息
     */
    Salary getSalyId(int id);

}


