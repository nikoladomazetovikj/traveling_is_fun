# Traveling Is Fun
SEEU - Programming In Java final project 

# Introduction

Traveling is the most beautiful part of life, but very often we
wonder which destination we would visit next. Therefore, with
the help of TravelingIsFun, you will be able to see how the rest
of you have fared on the trip that you may have planned to go
on and start the adventures and share it with other users.

# Table of contents

- [Project SetUp](#project-setup)
- [Database DDL](#database-ddl)
- [API Documentation](#api-documentation)

# Project SetUp

1. First clone this repository using following commands:

``````
cd/destination_folder (on your local machine)
git clone https://github.com/nikoladomazetovikj/traveling_is_fun.git
``````
2. Make sure that you are using `JDK 17`

3. You should build the `Gradle`
4. Create a `MySQL` database
5. Set your database properties in the `src/main/java/resources/aplication.properties`

```aidl
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.show-sql=true

spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
```

6. Note: Database data migration setup
 - You can use `spring.jpa.hibernate.ddl-auto=create-drop`, in case you want every time to drop all tables and create them on start
 - Or you can use `spring.jpa.hibernate.ddl-auto=update`, in case you don't want to lose all tables and data every time you start the application

7. This application is using `SpringBoot 2.7.6`
8. Necessary dependencies are : 

```aidl
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	runtimeOnly 'com.mysql:mysql-connector-j'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
```
 - Note: you can find them in `build.gradle`

9. You must use `Hibernate` to work with the database and queries

```aidl
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
```
 - You can find this one in `src/main/java/resources/aplication.properties`, or you can modified if you want on your local machine

10. Start the application: 
 - You must have some server like `APACHE`, `NGINX`
 - You should have `MySQL` database server setup
 - To test the application you can use every browser (only for the `GET` requests, or you can use `Postman` or `Insomnia`

    1. Start your local server
   2. Start the database server
   3. Run the application
   4. The default port is `localhost:8080`


# Database DDL

Here you can look at the database DDL:

1. Tables
```sql
create table categories
(
    id   bigint  null,
    name integer null
);

create table users
(
    id        bigint       null,
    country   varchar(255) null,
    email     varchar(255) null,
    is_admin  tinyint      null,
    is_bloger tinyint      null,
    name      varchar(255) null,
    password  varchar(255) null,
    surname   varchar(255) null,
    user_name varchar(255) null
);


create table posts
(
    id        bigint       null,
    category  varchar(255) null,
    content   longtext     null,
    title     varchar(255) null,
    author_id bigint       null
);


create table comments
(
    id      bigint       null,
    text    varchar(255) null,
    post_id bigint       null,
    user_id bigint       null
);


create table post_like
(
    user_id bigint null,
    post_id bigint null
);


create table post_rating
(
    post_id bigint  null,
    user_id bigint  null,
    rating  integer null
);


```

2. ERD Diagram

![traveling_is_fun](https://user-images.githubusercontent.com/58082595/215331760-f38d8e9a-ca53-4d4b-bcf4-2c88d8d20330.png)

# API Documentation
 
| HTTP Method | Endpoint | Description |
|-------------| --- | -- |
| GET         | /api/posts/allPosts | Find All Posts |
| POST        | /api/posts/create | Create New Post |
| PUT         | /api/posts/edit/:postId | Edit Post |
| DELETE      | /api/posts/delete/:postId | Delete Post|
| GET         | /api/users | Find All Users |
| POST        | /api/users/create | Create New User |
| DELETE      | /api/users/1/delete/:userId | Delete User|
| PUT         | /api/users/:userId/like/:postId | Like Post |
| POST        | /api/users/:userId/comment/:postId | Add Comment |
 
 - Usage and Examples
 
1. Users
 
	Request:
	```javascript
	 GET http://localhost:8080/api/users
	```
	Response:
	```json
		[
			{
				"id": 1,
				"name": "User 1",
				"country": "Macedonia",
				"surname": "surname",
				"email": "em@em.com",
				"userName": "username",
				"password": "hidden",
				"ratings": [],
				"admin": true,
				"blogger": true
			},
			{
				"id": 4,
				"name": "User 3",
				"country": "Mac3edonia",
				"surname": "surn3ame",
				"email": "em@em.c32om",
				"userName": "usern32ame",
				"password": "hidde23n",
				"ratings": [],
				"admin": true,
				"blogger": true
			},
			{
				"id": 5,
				"name": "User 4",
				"country": "Mac43edonia",
				"surname": "surn43ame",
				"email": "em@em.c432om",
				"userName": "usern432ame",
				"password": "hidde243n",
				"ratings": [],
				"admin": true,
				"blogger": true
			}
		]
 
	```
 
	Request:
	```javascript
	  POST http://localhost:8080/api/users/create
	```
	Body: 
	```json
	  {
		"name":"User 4",
		"country":"Mac43edonia",
		"surname":"surn43ame",
		"email":"em@em.c432om",
		"userName":"usern432ame",
		"password":"hidde243n",
		"isAdmin":true,
		"isBlogger":true
	 }
	```
	Request:
	```php
	  DELETE http://localhost:8080/api/users/1/delete/3
	```
	Response: no content
 
	Request:
	```php
	 PUT http://localhost:8080/api/users/1/like/1
	```
 
	Request:
	```php
	  POST http://localhost:8080/api/users/1/comment/1?comment=comment1
	```
 
2. Posts
 
	Request:
	```php
	 GET http://localhost:8080/api/posts/allPosts
	```
	Response:
	```json
	   [
		{
			"id": 1,
			"title": "Hello world ",
			"content": "Content ",
			"author": {
				"id": 1,
				"name": "User 4",
				"country": "Mac43edonia",
				"surname": "surn43ame",
				"email": "em@em.c432om",
				"userName": "usern432ame",
				"password": "hidde243n",
				"ratings": [],
				"admin": true,
				"blogger": true
			},
			"category": "LAK2ES",
			"comments": [],
			"likes": [],
			"ratings": []
		}
	   ]
	```
 
	Request:
	```php
	 POST http://localhost:8080/api/posts/create
	```
	Body:
	```json
	   {
		"title":"Hello world ",
		"content":"Content ",
		"userId":1,
		"category":"LAK2ES"
	   }
	```
 
	Request:
	```php
	  PUT http://localhost:8080/api/posts/edit/1
	```
	Body:
	```json
	   {
		"title":"Edited title",
		"content":"Edited content",
		"category":"Edited category"
	  }
	```
 
	Request:
	```php
	  DELETE http://localhost:8080/api/posts/delete/1
	```
	Response: no content





