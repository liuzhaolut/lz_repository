package com.jdbc.anli.zz;

import com.jdbc.anli.DButils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ctrl+Alt+t
 */
public class AccountServiceImpl implements AccountService{

    @Override
    public void transfer(String fromNo, String pwd, String toNo, double money) {
        AccountDao dao = new AccountDaoImpl();
        try {
            DButils.begin();
//        验证fromNo是否存在
            Account account = dao.selectOne(fromNo);
            if (account == null){
                throw new RuntimeException("卡号不存在！");
            }
//        验证fromNo密码是否正确
            if (!account.getPassword().equals(pwd)){
                throw new RuntimeException("密码错误！！");
            }
//        验证fromNo余额是否充足
            if (account.getBalance() < money){
                throw new RuntimeException("余额不足。。。。");
            }
//        验证toNo是否存在
            Account account1 = dao.selectOne(toNo);
            if (account1 == null){
                throw new RuntimeException("对方卡号不存在！");
            }
//        减少fromNo余额
            account.setBalance(account.getBalance() - money);
            dao.update(account);
//        增加toNo余额
            account1.setBalance(account1.getBalance() + money);
            dao.update(account1);
            System.out.println("转账成功");
//            转账成功提交
            DButils.commit();
        } catch (RuntimeException e) {
            System.out.println("转账失败");
            DButils.rollback();
            e.printStackTrace();
        }
    }
}
