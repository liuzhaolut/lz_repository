package com.jdbc.anli.zz;

public interface AccountDao {
    /**
     * 插入账户
     * @param account
     * @return
     */
    public int insert(Account account);

    /**
     * 删除账户
     * @param account
     * @return
     */
    public int delete(Account account);

    /**
     * 更新数据
     * @param account
     * @return
     */
    public int update(Account account);

    /**
     * 查询单个
     * @param cardNo
     * @return
     */
    public Account selectOne(String cardNo);
}
