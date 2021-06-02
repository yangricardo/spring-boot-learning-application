package com.example.task.rest;


import com.example.task.model.ITaskRepository;
import com.example.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository repository;

    public TaskController(ITaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    @GetMapping("")
    List<Task> index() {
        return repository.findAllByOrderByName();
    }
}