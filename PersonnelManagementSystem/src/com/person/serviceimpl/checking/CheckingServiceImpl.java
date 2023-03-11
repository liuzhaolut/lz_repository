package com.person.serviceimpl.checking;

import com.person.dao.checking.CheckingDao;
import com.person.daoimpl.checking.CheckingDaoImpl;
import com.person.pojo.Checking;
import com.person.pojo.Emp;
import com.person.service.checking.CheckingService;

import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - 考勤service实现类
 * @date 2022/6/25
 */
public class CheckingServiceImpl implements CheckingService {
    private CheckingDao dao = new CheckingDaoImpl();

    /**
     * 新增考勤记录
     * @param checking 考勤信息
     * @return 返回新增是否成功
     */
    @Override
    public boolean insertChecking(Checking checking) {
        boolean result = false;
        Integer id = checking.getEmpId();
        Emp emp = dao.selectOneEmp(id);
        if (emp != null){
            checking.setEmpId(emp.getEmpId());
            checking.setEmpName(emp.getEmpName());
            result  = dao.insertChecking(checking);
        }
        return result;
    }

    /**
     * 查询所欲考勤信息
     * @return 返回所有考勤信息
     */
    @Override
    public List<Checking> selectCheckingAll() {
        return dao.selectCheckingAll();
    }

    /**
     * 删除对应考勤记录
     * @param parseInt 考勤id
     * @return 饭后是否删除成功
     */
    @Override
    public boolean deleteChecking(int parseInt) {
        Checking checking = new Checking();
        checking.setCheckId(parseInt);
        return dao.deleteChecking(checking);
    }

    /**
     * 查询单条考勤记录
     * @param parseInt 考勤id
     * @return 返回考勤信息
     */
    @Override
    public Checking selectOneChecking(int parseInt) {
        return dao.selectOneChecking(parseInt);
    }

    /**
     * 修改考勤记录
     * @param checking 考勤信息
     * @return 返回是否修改成功
     */
    @Override
    public boolean UpdateChecking(Checking checking) {
        boolean result = false;
        if (checking != null){
            result = dao.updateChecking(checking);
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
        return dao.searchChecking(key);
    }

    /**
     * 模糊查询查询有无员工
     * @param key 模糊查询的key
     * @return 饭后是否有此员工
     */
    @Override
    public boolean selectNameEmp(String key) {
        return dao.selectNameEmp(key);
    }

    /**
     * @param parseInt 考勤id
     * @param empName 员工姓名
     * @return 返回查询到的员工信息
     */
    @Override
    public Emp selectEmpId(int parseInt, String empName) {
        return dao.selectEmpId(parseInt,empName);
    }
}
