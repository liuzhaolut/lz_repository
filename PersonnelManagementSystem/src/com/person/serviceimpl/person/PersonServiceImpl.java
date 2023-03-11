package com.person.serviceimpl.person;

import com.person.dao.checking.CheckingDao;
import com.person.dao.person.PersonDao;
import com.person.dao.wage.WageDao;
import com.person.daoimpl.checking.CheckingDaoImpl;
import com.person.daoimpl.person.PersonDaoImpl;
import com.person.daoimpl.wage.WageDaoImpl;
import com.person.pojo.Emp;
import com.person.service.person.PersonService;

import java.util.List;

/**
 * @author 张天旭
 * 员工管理 - 逻辑控制：接口实现类
 * @date 2022/6/22 11:32
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();
    private WageDao wageDao = new WageDaoImpl();
    private CheckingDao checkingDao = new CheckingDaoImpl();

    /**
     * 通过员工号查询一个员工信息
     *
     * @param empId 员工号
     * @return 员工对象
     */
    @Override
    public Emp selectEmpOneService(int empId) {
        Emp emp = personDao.selectEmpOne(empId);
        return emp;
    }

    /**
     * 查询所有员工信息
     *
     * @return 员工对象的集合
     */
    @Override
    public List<Emp> selectEmpAllService() {
        List<Emp> empList = personDao.selectEmpAll();
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
        int state = personDao.update(emp, empId);
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
        int state = personDao.deleteOne(empId);
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
        int state = personDao.insert(emp);
        return state;
    }

    /**
     * 删除所有员工信息
     * @return 返回受影响的行数
     */
    @Override
    public int deleteAll() {
        return personDao.deleteAll();
    }
}
