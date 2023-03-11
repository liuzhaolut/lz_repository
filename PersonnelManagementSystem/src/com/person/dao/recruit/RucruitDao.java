package com.person.dao.recruit;

import com.person.pojo.Recruit;

import java.util.List;
/**
 * @author 高丽芳
 * 招聘管理-数据库操作：接口层
 */
public interface RucruitDao {

    /**
     * 查询所有招聘信息
     *
     * @return 返回所有招聘信息
     */
    List<Recruit> getAllRecruit();


    /**
     * 删除操作
     * @param reId 招聘id
     * @return 返回是否删除成功
     */
    public boolean delRecurit(int reId);

    /**
     * 新增招聘信息
     *
     * @param recruit 招聘信息
     * @return 饭后新增的条数
     */
    int insertRecruit(Recruit recruit);

    /**
     * 查询单个招聘信息
     * @param reName 招聘职位
     * @return 返回招聘信息
     */
    Recruit findRecruit(String reName);


    /**
     * 修改-回显信息
     *
     * @param reId 招聘id
     * @return 返回招聘信息
     */
    public Recruit getRecruitById(int reId);

    /**
     * 修改招聘信息
     * @param recruit 招聘信息
     * @return 返回是否修改成功
     */
    public boolean upRecruit(Recruit recruit);

    /**
     * 清空招聘信息
     * @return 返回是否清空所有招聘信息
     */
    boolean deleteAllRecruit();
}
