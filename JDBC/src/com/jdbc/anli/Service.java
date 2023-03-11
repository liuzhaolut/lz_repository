package com.jdbc.anli;

import java.util.List;

/**
 * 业务层
 */
public interface Service {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
    int deleteUser(User user);
    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 查询y一个
     * @return
     */
    User selectOne(User user);
    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();
}
