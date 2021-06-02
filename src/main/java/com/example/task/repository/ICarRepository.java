package com.example.task.repository;

import com.example.task.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICarRepository extends JpaRepository<Car, Long> {
}
