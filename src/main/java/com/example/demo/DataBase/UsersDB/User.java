package com.example.demo.DataBase.UsersDB;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

    @Entity
    @JsonIgnoreProperties("password")
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String login;
        private String password;
        private String token;

        public User(){}

        @Override
        public String toString() {
            return "Login:"+login+" Password:"+password;
        }

        public User(String login, String password){
            this.login = login;
            this.password = password;
        }

        public String token(){
            this.token = UUID.randomUUID().toString();
            return this.token;
        }

        public String getToken(){
            return token;
        }

        public String getLogin(){
            return this.login;
        }

    }