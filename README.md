# Car-DataBase
Car DataBase Application backend in Spring Boot.  
This repo is the backend for Car Applicatin, which provides end users with car infomation and CRUD functionalities.  
The backend is developed in Spring Boot framework and uses JPA to connect to MySQL database.
CRUD functionalities are implemented with CrudRepository(PagingAndSortingRepository) provided by Spring Boot Data JPA.
There are three tables in database: car, owner and user. The owner table has a one-to-many relationship with car table and the
user table records the information of authorized users.  
The backend creates a fully functional RESTful web service with Spring Data REST and is secured with Spring Boot Security and
JWT authentication.
