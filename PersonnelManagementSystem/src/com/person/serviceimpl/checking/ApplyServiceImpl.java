package com.person.serviceimpl.checking;

import com.person.dao.checking.ApplyDao;
import com.person.dao.checking.CheckingDao;
import com.person.daoimpl.checking.ApplyDaoImpl;
import com.person.daoimpl.checking.CheckingDaoImpl;
import com.person.pojo.Apply;
import com.person.pojo.Emp;
import com.person.service.checking.ApplyService;

import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - 请假单service实现类
 * @date 2022/6/25
 */
public class ApplyServiceImpl implements ApplyService {
    private ApplyDao dao = new ApplyDaoImpl();

    /**
     * 通过部门名称，员工名称获取用户id
     * @param depName 部门名字
     * @param empName 员工名字
     * @return  员工id
     */
    @Override
    public Integer getCheckId(String depName, String empName) {
        return dao.getCheckId(depName,empName);
    }

    /**
     * 新增请假信息
     * @param apply 请假信息
     * @return 返回是否新增成功
     */
    @Override
    public boolean addApply(Apply apply) {
        return dao.addApply(apply);
    }

    /**
     * 获取所有请假单
     * @return 返回所有请假信息
     */
    @Override
    public List<Apply> getApplyAll() {
        return dao.getApplyAll();
    }

    /**
     * 删除此请假单
     * @param parseInt 请假单id
     * @return 返回是否删除成功
     */
    @Override
    public boolean deleteApply(int parseInt) {
        Apply apply = dao.selectOneApply(parseInt);
        if (apply != null){
            return dao.deleteApply(parseInt);
        }
        return false;
    }

    /**
     * 通过id查询请假单
     * @param key 请假单id
     * @return 返回请假单信息
     */
    @Override
    public Apply searchApply(int key) {
        return dao.selectOneApply(key);
    }


}
