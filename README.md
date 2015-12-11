# Swagata testing SpringHibernate

you need to start the project:  
install apache-tomcat-8.0.21  
install  database MYSQL  
and also Maven  

```mysql
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

```
```mysql
insert into usersdb.users values(1, 'adele', 'hello', 'adle@gmail.com');
insert into usersdb.users values(2, 'swagata', 'pandit', 'swagata@gmail.com');
insert into usersdb.users values(3, 'rohan', 'pandit', 'rohan@gmail.com');
```

http://localhost:8080/swagataSpringHibernateORM/getUserList

```mysql
CREATE TABLE usersdb.tasks (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `taskName` varchar(45) NOT NULL,
  `date` DATE NOT NULL,
  `estimateFirst` varchar(45) NOT NULL,
  `estimateSecond` varchar(45) NOT NULL,
  `totalEstimateTime` varchar(45) NOT NULL,
  `actualTotalTime` varchar(45) NOT NULL,
  `timeOfWork` varchar(45) NOT NULL,
  `userId` int(11),
  PRIMARY KEY (`taskId`),
  CONSTRAINT fk_tasks_users FOREIGN KEY(userId) REFERENCES users(userId))
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

https://github.com/spring-projects/spring-framework/wiki/Migrating-from-earlier-versions-of-the-Spring-Framework

