package com.example.task.repository;

import com.example.task.model.Task;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface ITaskRepository extends CrudRepository<Task,Long> {
    public Task findByName(String name);
    public Task findByNameIgnoreCase(String name);
    public Task findByNameAndId(String name, Long id);
    public Optional<Task> findById(Long id);
    public List<Task> findAllByOrderByName();
}
