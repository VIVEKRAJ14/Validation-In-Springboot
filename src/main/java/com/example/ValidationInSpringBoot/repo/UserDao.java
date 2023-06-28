package com.example.ValidationInSpringBoot.repo;

import com.example.ValidationInSpringBoot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    List<User>list;

    public UserDao(){
        list=new ArrayList<>();
        list.add(new User(1,"vivek","1999-02-14","raj@gmail.com","1234567890","2023-04-29","11:10 pm"));
    }

    public boolean save(User user) {
        list.add(user);
        return true;
    }

    public List<User> getDataSourceUser() {
        return list;
    }

    public boolean updateUserById(int userid, User user)
    {
        for ( User userObj : list ) {
            if ( userObj.getUserid()==userid ) {
                userObj.setUsername(user.getUsername());
                userObj.setDateOfBirth(user.getDateOfBirth());
                userObj.setEmail(user.getEmail());
                userObj.setPhone_Number(user.getPhone_Number());
                userObj.setDate(user.getDate());
                userObj.setTime(user.getTime());
                return true;
            }
        }
        return false;
    }

    public Boolean removeUserById(User user) {
        list.remove(user);
        return true;
    }
}