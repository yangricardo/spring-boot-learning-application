package com.example.task.rest;

import com.example.task.model.Car;
import com.example.task.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @ResponseStatus(code = HttpStatus.CREATED)
    Car create(@RequestBody Car car){
        return this.carRepository.save(car);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.FOUND)
    List<Car> index() {
        return this.carRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    Optional<Car> findById(@PathVariable("id") Long id) {
        return this.carRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") Long id) {
        this.carRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Car> updateById(@PathVariable("id") Long id, @RequestBody Car car) {
       return this.carRepository.findById(id).map(record->{
           record.setName(car.getName());
           record.setColor(car.getColor());
           record.setYear(car.getYear());
           return this.carRepository.save(record);
       });
    }
}
