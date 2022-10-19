package com.service;

import com.model.Login;
import com.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAO {
    private static List<User> users = new ArrayList<>();

    static {
        User u1 = new User();
        u1.setAge(10);
        u1.setName("htc");
        u1.setAccount("htc");
        u1.setEmail("htc@codegym.vn");
        u1.setPassword("htc");
        users.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("adm");
        u2.setAccount("adm");
        u2.setEmail("adm@codegym.vn");
        u2.setPassword("adm");
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("hoanghieu");
        u3.setAccount("hoanghieu");
        u3.setEmail("hoanghieu@gmail.com");
        u3.setPassword("761321");
        users.add(u3);
    }

    public static  User checkLogin(Login login){
        for (User u : users){
            if(u.getAccount().equals(login.getAccount()) && (u.getPassword().equals(login.getPassword()))){
                return u ;
            }
        }
        return null;
    }
}
