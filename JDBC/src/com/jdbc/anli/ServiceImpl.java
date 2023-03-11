package com.jdbc.anli;

import java.util.List;

public class ServiceImpl implements Service{
    private Dao dao;
    @Override
    public int addUser(User user) {
        dao = new DaoImpl();
        User user1 = dao.selectOne(user);
        if (user1.getUsername() == null) {
            int count = dao.addUser(user);
            System.out.println("插入成功: " + count);
            return count;
        } else {
            System.out.println("插入失败");
        }
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        dao = new DaoImpl();
        User user1 = dao.selectOne(user);
        if (user1 == null) {
            System.out.println("无此用户！ " + user.getUsername());
        } else {
            int count = dao.deleteUser(user);
            System.out.println("删除成功：" + count);
            return count;
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public User selectOne(User user) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }
}
