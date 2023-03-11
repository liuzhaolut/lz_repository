package com.person.serviceimpl.wage;

import com.person.dao.person.PersonDao;
import com.person.dao.wage.WageDao;
import com.person.daoimpl.person.PersonDaoImpl;
import com.person.daoimpl.wage.WageDaoImpl;
import com.person.pojo.Emp;
import com.person.pojo.Salary;
import com.person.service.wage.WageService;

import java.util.List;

/**
 * @author 吴洋洋
 * @date 2022/6/28 16:50
 */
public class WageServiceImpl implements WageService {
    private WageDao wageDao = new WageDaoImpl();
    private PersonDao personDao = new PersonDaoImpl();

    /**
     * 查询所有工资信息
     * @return 返回全部工资信息
     */
    @Override
    public List<Salary> selectSalaryAll() {
        List<Salary> salaries = wageDao.selectSalaryAll();
        return salaries;
    }

    /**
     * 查询单个工资信息
     * @param id 工资id
     * @return 返回工资信息
     */
    @Override
    public Salary selsectId(int id) {
        return wageDao.selectSalaryId(id);
    }



    /**
     * 删除
     * @param id 工资id
     * @return 返回受影响的行数
     */
    @Override
    public int deletSalary(int id) {
        int result = wageDao.deleteId(id);
        return result;
    }

    /**
     *
     * @param salary 工资信息
     * @return 返回受影响行数
     */
    @Override
    public int insertSaraly(Salary salary) {
        int temp = 0;
        int empid = salary.getEmpId();
        Emp emp = personDao.selectEmpOne(empid);
        if (emp != null)  {
        salary.setEmpName(emp.getEmpName());
        temp = wageDao.inseretSaraly(salary);
        }
        return temp;
    }


}
