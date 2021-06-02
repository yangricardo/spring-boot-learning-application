package com.example.task.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ITaskRepository extends CrudRepository<Task,Long> {
    public Task findByName(String name);
}
