package com.example.demo.DataBase.PointsDB;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PointsRepository extends CrudRepository<Point, Long> {
     List<Point> findByLogin(String Login);
}
