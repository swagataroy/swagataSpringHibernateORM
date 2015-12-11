package com.swagata.persistence;

import com.swagata.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskPersistence<Task> {

    List<Task> findTasks(Long id);

    List<Task> findFilterTasks(Long userId, Date firstDate, Date secondDate);

    Task findBuId(Long id);

    void create(Task task);

    void update(Task task);

    void delete(Long id);
}
