package com.swagata.persistence.hibernate.impl;

import com.swagata.entity.Task;
import com.swagata.persistence.TaskPersistence;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

@Repository
public class TaskPersistenceImpl implements TaskPersistence<Task> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Task> findTasks(Long userId) {
        return em.createQuery("From Task where userId = :userId", Task.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Task> findFilterTasks(Long userId, Date firstDate, Date secondDate) {
        return em.createQuery("From Task where userId = :userId and DATE > :firstDate and DATE < :secondDate", Task.class)
                .setParameter("userId", userId).setParameter("firstDate", firstDate).setParameter("secondDate", secondDate).getResultList();
    }

    @Override
    public Task findBuId(Long id) {
        return em.find(Task.class, id);
    }

    @Override
    public void create(Task task) {
        em.persist(task);
    }

    @Override
    public void update(Task task) {
        em.merge(task);
    }

    @Override
    public void delete(Long id) {
        Task task = new Task();
        task.setTaskId(id);
        Object o = em.merge(task);
        em.remove(o);
    }
}
