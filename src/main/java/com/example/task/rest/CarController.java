package com.example.task.rest;

import com.example.task.model.Car;
import com.example.task.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ICarRepository carRepository;

    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    @ResponseBody
    Car create(@RequestBody Car car){
        return this.carRepository.save(car);
    }
}
