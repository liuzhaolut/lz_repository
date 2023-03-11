package com.person.dao.checking;

import com.person.pojo.Apply;

import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - 数据库操作：请假单接口层
 * @date 2022/6/25
 */
public interface ApplyDao {
    /**
     * 通过部门名称，员工名称获取用户id
     * @param depName 部门名字
     * @param empName 员工名字
     * @return  员工id
     */
    Integer getCheckId(String depName, String empName);

    /**
     * 新增请假信息
     * @param apply 请假信息
     * @return 返回是否新增成功
     */
    boolean addApply(Apply apply);

    /**
     * 获取所有请假单
     * @return 返回所有请假信息
     */
    List<Apply> getApplyAll();

    /**
     * 查询有无此请假单
     * @param parseInt 请假单id
     * @return 返回请假单信息
     */
    Apply selectOneApply(int parseInt);

    /**
     * 删除此请假单
     * @param parseInt 请假单id
     * @return 返回是否删除成功
     */
    boolean deleteApply(int parseInt);
}
