package com.example.task.rest;

import com.example.task.model.ITaskRepository;
import com.example.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("")
    @ResponseBody
    Task create(@RequestParam("name") String name) {
        Task task = new Task(name);
        return repository.save(task);
    }

    @GetMapping("/{id}")
    Optional<Task> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Task update(@PathVariable("id") Long id, @RequestParam("name") Optional<String>  name) {
        Optional<Task> foundTask = repository.findById(id);
        if (foundTask.isPresent()) {
            if(name.isPresent()) {
                foundTask.get().setName(name.get());
            }
            return repository.save(foundTask.get());
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    Long delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return id;
    }
}
