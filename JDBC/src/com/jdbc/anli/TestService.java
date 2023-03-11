package com.jdbc.anli;

public class TestService {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        User user = new User();
        user.setUserId(2);
        user.setUsername("dt");
        user.setPassword("dtxx");
        user.setAddress("乌漆嘛黑，呼哩哗啦");
        user.setPhone("12552163944");
        int count = service.addUser(user);
        if (count >= 1){
            System.out.println("===============  " + count);
        }
//        int count = service.deleteUser(user);
//        if (count >= 1) {
//            System.out.println("删除成功： " + count + " 条");
//        } else {
//            System.out.println("删除失败");
//        }
    }
}
