package com.swagata.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @OneToMany(mappedBy = "user",  fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Task> taskList;


    public User() {}

    public User(Long UserId) {
        this.userId = UserId;
    }

    public User(String UserName) {
        this.userName = UserName;
    }

    public User( Long UserId, String UserName) {

        this.userId = UserId;
        this.userName = UserName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
