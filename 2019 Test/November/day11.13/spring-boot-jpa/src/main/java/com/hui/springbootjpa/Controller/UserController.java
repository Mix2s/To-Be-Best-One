package com.hui.springbootjpa.Controller;

import com.hui.springbootjpa.entity.User;
import com.hui.springbootjpa.repository.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepostory userRepostory;


//    @GetMapping("/user/id")
//    public User getUser(@PathVariable("id") Integer id){
//        User user = userRepostory.findOne(id);
//        return user;
//    }

    public User insertUser(User user){
        User save = userRepostory.save(user);
        return save;
    }

}
