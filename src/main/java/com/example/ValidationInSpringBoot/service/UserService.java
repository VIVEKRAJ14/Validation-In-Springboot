package com.example.ValidationInSpringBoot.service;

import com.example.ValidationInSpringBoot.model.User;
import com.example.ValidationInSpringBoot.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public String addNew(User user) {
        boolean ans=userDao.save(user);
        if(ans){
            return "User added successfully..";
        }else{
            return "User Not added !!";
        }

    }

    public List<User> getAll() {
        return userDao.getDataSourceUser();
    }

    public User getUserById(int userid) {
        List<User>now=userDao.getDataSourceUser();
        for(User user:now){
            if(user.getUserid()==userid){
                return  user;
            }
        }
        return null;
    }


    public String updateUser(int userid,User user) {
        boolean updateStatus =  userDao.updateUserById(userid,user);

        if(updateStatus)
        {
            return "User: " + userid + " was updated!!!";
        }
        else
        {
            return "User: " + userid + " does not exist!!!";
        }
    }

    public String deleteUserById(int userid)
    {
        List<User> helperList = userDao.getDataSourceUser();
        Boolean status = false;

        for ( User user : helperList ) {
            if ( user.getUserid()==userid) {
                status = userDao.removeUserById(user);
                if ( status ) {
                    return "User " + userid + " removed from database successfully!!!";
                }
                else {
                    return "User " + userid + " cannot be removed from database (Database error)!!!";
                }
            }
        }
        return "User " + userid + " Not Found!!!";
    }
}