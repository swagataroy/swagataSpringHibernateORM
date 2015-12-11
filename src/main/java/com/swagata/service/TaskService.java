package com.swagata.service;



import com.swagata.entity.Task;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface TaskService<Task> {

    List<Task> getTaskList(Long id);

    List<Task> getFilterTaskList(Long userId, Date firstDate, Date secondDate);

    Task getTaskById(Long id);

    void saveOrUpdate(Task task);

    void delete(Long id);
}
