# Watchshop
## About the Project 

This is a basic springboot application which simulates an online watch shop. The idea is to accept 1 request in /checkout with a json file that lists watch ids, 
a total price for those watches will be returned (including the discount). 

## Built with

The project is build with following main frameworks and is run with Java 17:
- Spring boot
- Maven
- Hibernate 

## How to run
The application is currently deployed on to Heroku and can be accessed via: 

### https://hb-watchshop.herokuapp.com/checkout
(Password may change for database, which will lead to the application not working)

The application can also be accessed by cloning the project to your ide, running mvn clean install and then running the WatchshopApplication class. 
Once the application has started go to localhost:8080/checkout.

Once the page has loaded, you need to change the call to be a post method. 
You also need to change the Headers to be:
Accept: application/json
Content-Type: application/json

The body can then accept a list of string ids from 1-4:

![image](https://user-images.githubusercontent.com/36417804/206841245-422008d4-d8cd-44b9-9de7-ef949afef9b9.png)

## How I approached the project
I attempted to show my approach my adding the commits and showing what steps I took: 
https://github.com/jackbindin/watchshop/commits/master

- I first decided to host the project in heroku since I can host both the database and the application there. 
- Once I created the database, I built the spring boot app in IntelliJ. I then created the model class and connected to the postgres database in heroku. 
- Next step was adding the repository and the services (with corresponding unit tests)
- I then created the controller class  (with corresponding it test)
- Once the project was added to github, I added the github project to my heroku project and deployed it. 

## How I would improve the project if I had more time (and more resources)

- I would like to add a gitlab pipeline which included the mvn clean install and sonarcube quality check
- I would create an abract class for products, rather than the application just being for watches
- If the project was going to be used to a larger scale, I would add caching and some batching using streaming on the repository rather than returning a list











