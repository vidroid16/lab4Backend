package com.example.demo.LogicPckg;

import com.example.demo.DataBase.PointsDB.Point;
import com.example.demo.DataBase.PointsDB.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
public class CheckController {
    @Autowired
    PointsRepository pointsRepository;

    @PostMapping("/check")
    public Object check(@RequestBody Point point){
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("x", String.valueOf(point.getX()));
        hm.put("y", String.valueOf(point.getY()));
        hm.put("r", String.valueOf(point.getR()));
        hm.put("login", point.getLogin());
        System.out.println(point.getLogin());
        hm.put("isIn", point.isIn()?"true":"false");
        System.out.println(point.isIn());
        pointsRepository.save(point);
        return hm;
    }
    @PostMapping("/userpointsgetter")
    public Object getUserPoints(@RequestBody String login){
        String logint = login.replace("=", "");
        System.out.println(logint);
        List<Point> list = pointsRepository.findByLogin(logint);
        System.out.println("Shas buit SSss");
        System.out.println(list.size());
        list.forEach((p)->{
            System.out.println(p.getX()+"SSSSSsssssSSSSssss");
        });
        return pointsRepository.findByLogin(logint);

    }
}
