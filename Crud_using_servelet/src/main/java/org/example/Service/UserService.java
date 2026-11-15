package org.example.Service;

import org.example.Model.User;

import java.util.*;

public class UserService {

    private Map<Integer, User> db;

    public UserService(){
        db = new HashMap<>();
    }

    public User createUser(User request){
        db.put(request.getId(),request);

        return request;
    }
    public List<User> getall(){
        List<User> res = new ArrayList<>();
        for(User user : db.values()){
            res.add(user);
        }

        return  res;
    }

    public User getById(Integer id){
        return db.getOrDefault(id,null);
    }

    public User updateUser(Integer id, User user) {
        if(!db.containsKey(id)){
            return null;
        }
        user.setId(id);
        db.put(id,user);

        return user;
    }
}