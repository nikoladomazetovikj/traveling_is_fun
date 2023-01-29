# Traveling Is Fun
SEEU - Programming In Java final project 

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
 - To test the application you can use every browser (only for the `GET` requests`, or you can use `Postman` or `Insomnia`

    1. Start your local server
   2. Start the database server
   3. Run the application
   4. The default port is `localhost:8080`