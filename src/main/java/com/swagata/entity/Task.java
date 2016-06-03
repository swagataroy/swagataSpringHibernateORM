package com.swagata.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

//Testing commit
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private Long taskId;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "date")
    @Temporal(value=TemporalType.DATE)
    private Date date;

    @Column(name = "estimateFirst")
    private String estimateFirst;

    @Column(name = "estimateSecond")
    private String estimateSecond;

    @Column(name = "totalEstimateTime")
    private String totalEstimateTime;

    @Column(name = "actualTotalTime")
    private String actualTotalTime;

    @Column(name = "timeOfWork")
    private String timeOfWork;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    public Task(String taskName, Date date, String estimateFirst, String estimateSecond, String totalEstimateTime, String actualTotalTime, String timeOfWork) {
        this.taskName = taskName;
        this.date = date;
        this.estimateFirst = estimateFirst;
        this.estimateSecond = estimateSecond;
        this.totalEstimateTime = totalEstimateTime;
        this.actualTotalTime = actualTotalTime;
        this.timeOfWork = timeOfWork;
    }

    public Task() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEstimateFirst() {
        return estimateFirst;
    }

    public void setEstimateFirst(String estimateFirst) {
        this.estimateFirst = estimateFirst;
    }

    public String getEstimateSecond() {
        return estimateSecond;
    }

    public void setEstimateSecond(String estimateSecond) {
        this.estimateSecond = estimateSecond;
    }

    public String getTotalEstimateTime() {
        return totalEstimateTime;
    }

    public void setTotalEstimateTime(String totalEstimateTime) {
        this.totalEstimateTime = totalEstimateTime;
    }

    public String getActualTotalTime() {
        return actualTotalTime;
    }

    public void setActualTotalTime(String actualTotalTime) {
        this.actualTotalTime = actualTotalTime;
    }

    public String getTimeOfWork() {
        return timeOfWork;
    }

    public void setTimeOfWork(String timeOfWork) {
        this.timeOfWork = timeOfWork;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
