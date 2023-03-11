package com.person.service.wage;

import com.person.pojo.Emp;
import com.person.pojo.Salary;

import java.util.List;


/**
 * @author 吴洋洋
 * 工资管理 - 逻辑控制操作：接口类
 * @date 2022/6/22 11:32
 */
public interface WageService {


    /**
     * 查询所有工资信息
     * @return 返回全部工资信息
     */
    List<Salary> selectSalaryAll();

    /**
     * 查询单个工资信息
     * @param i 工资id
     * @return 返回工资信息
     */
    Salary selsectId(int i);

    /**
     * 删除
     * @param id 工资id
     * @return 返回受影响的行数
     */
    int deletSalary(int id);

    /**
     *
     * @param salary 工资信息
     * @return 返回受影响行数
     */
    int insertSaraly(Salary salary);

}
