# MircoServices
level1
This level1 mircoservices include 4 different project of spring boot. 
1.DiscoveryServer : Discovery Server is basically Eureka server.
2.Movie Catalog: This spring boot project fetch data from movie info project and rating project. In this project I am using RestTemplace to create micoServices. and loadblancer to balance load.
3.Moive Info: this spring boot project include the information of the movies.
4. Ratings: This spring boot project include the rating of the movies.

This is simple project where you can understand what is mircoServices. how to bind different projects. 

Steps of executions
step1: Run rating and movie info project.
step2: run movie catalog service so that it can fetch data from running movie info and rating project
step3. run dicovery services. it will register all the three project in to eureka server. and you can monitor the status of all the project
