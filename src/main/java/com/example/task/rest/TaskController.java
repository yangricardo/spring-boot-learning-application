package com.example.task.rest;


import com.example.task.model.ITaskRepository;
import com.example.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    List<Task> index() {
        return repository.findAllByOrderByName();
    }

    @PostMapping("")
    @ResponseBody
    Task create(@RequestParam("name") String name) {
        Task task = new Task(name);
        return repository.save(task);
    }
}
