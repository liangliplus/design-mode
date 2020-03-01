package com.templatemethod.combination_implement;

public class UserDao extends MyJDBCTemplate{

    public static void main(String[] args) {
        UserDao user = new UserDao();
        user.add(new Object());
        user.update(1);
    }

}
