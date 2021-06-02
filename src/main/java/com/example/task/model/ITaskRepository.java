package com.example.task.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ITaskRepository extends CrudRepository<Task,Long> {
    public Task findByName(String name);
    public Task findByNameIgnoreCase(String name);
    public Task findByNameAndId(String name, Long id);
    public List<Task> findAllByOrderByName();
}
