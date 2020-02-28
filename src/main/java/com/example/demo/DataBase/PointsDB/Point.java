package com.example.demo.DataBase.PointsDB;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double x;
    private double y;
    private int r;
    private String login;
    private boolean isIn;

    public Point(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isIn() {
        System.out.println(y+"<="+-r);
        if((y>=-r) && (y<=0) && (x>=-r) && (x<=0)){
            return true;
        }
        if(y>=0 && (y<=(r-x)/2) && x>=0){
            return true;
        }
        if((Math.pow(x, 2)+Math.pow(y , 2)<=Math.pow(((double)r)/2, 2)) && (x<=0) && (y>=0)){
            return true;
        }
        return false;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public Point(double x, double y, int r, String login, boolean isIn) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.login = login;
        this.isIn = isIn;
    }
}