package com.person.service.recruit;

import com.person.pojo.Recruit;

import java.util.List;
/**
 * @author 高丽芳
 * 招聘管理-逻辑控制操作:接口层
 */
public interface RecruitService {

    /**
     * 查询所有招聘信息
     *
     * @return 返回所有招聘信息
     */
    List<Recruit> getAllRecruit();

    /**
     * 新增
     * @param recruit 招聘信息
     * @return 返回受影响行数
     */
    int insertRecruit(Recruit recruit);

    /**
     * 查询单个招聘信息
     * @param reName 招聘职位
     * @return 返回招聘信息
     */
    Recruit findRecruit(String reName);

    /**
     * 清空招聘信息
     * @return 返回是否清空所有招聘信息
     */
    boolean deleteAllRecruit();
}
