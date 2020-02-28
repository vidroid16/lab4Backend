package com.example.demo.AuthPckg;

import com.example.demo.DataBase.UsersDB.User;
import com.example.demo.DataBase.UsersDB.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/reg")
    public Object reg(@RequestBody LoginForm loginForm){
        User user = new User(loginForm.getLogin(),loginForm.getPassword());
        System.out.println("regISTER");
        try{
            User u = usersRepository.findByLogin(loginForm.getLogin());
            System.out.println(u.toString());
            return 400;
        }catch (Exception e){
            usersRepository.save(user);
            return 200;
        }
    }
    @PostMapping("/log")
    public Object log(@RequestBody LoginForm loginForm){
        User user = new User(loginForm.getLogin(),loginForm.getPassword());
        try{
            User u = usersRepository.findByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword());
            System.out.println(u.toString());
            return 200;
        }catch (Exception e){
            //usersRepository.save(user);
            return 400;
        }
    }
}

