package com.in28minutes.rest.webservices.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            usersCount++;
            user.setId(usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    // My work

    public User deleteById(int id){
        List<User> newUsers = new ArrayList<>();
        User deletedUser = null;

        for(User user: users){
            if(user.getId().equals(id)){
                deletedUser = user;
                continue;
            }
            newUsers.add(user);
        }
        users = newUsers;
        return deletedUser;
    }
}
