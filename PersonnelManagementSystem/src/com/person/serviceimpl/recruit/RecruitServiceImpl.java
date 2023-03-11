package com.person.serviceimpl.recruit;

import com.person.daoimpl.recruit.RecruitDaoImpl;
import com.person.dao.recruit.RucruitDao;
import com.person.pojo.Recruit;
import com.person.service.recruit.RecruitService;

import java.util.List;
/**
 * @author 高丽芳
 * 招聘管理-逻辑控制操作:接口实现类
 */
public class RecruitServiceImpl implements RecruitService {
    private RucruitDao dao = new RecruitDaoImpl();
    /**
     * 查询所有招聘信息
     * @return 返回所有招聘信息
     */
    @Override
    public List<Recruit> getAllRecruit() {
        return dao.getAllRecruit();
    }

    /**
     * 新增
     *
     * @param recruit 招聘信息
     * @return 返回受影响行数
     */
    @Override
    public int insertRecruit(Recruit recruit) {
        return dao.insertRecruit(recruit);
    }

    /**
     * 查询单个招聘信息
     * @param reName 招聘职位
     * @return 返回招聘信息
     */
    @Override
    public Recruit findRecruit(String reName) {
        Recruit recruit=dao.findRecruit(reName);
        return recruit;
    }

    /**
     * 清空招聘信息
     * @return 返回是否清空所有招聘信息
     */
    @Override
    public boolean deleteAllRecruit() {
        return dao.deleteAllRecruit();
    }

}
