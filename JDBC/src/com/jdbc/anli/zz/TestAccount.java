package com.jdbc.anli.zz;

public class TestAccount {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();
        service.transfer("6002","1234","6003",1000);
    }
}
