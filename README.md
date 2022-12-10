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

The application can also be access by cloning the project to your ide, running mvn clean install and then running the WatchshopApplication class. 
Once the application has started go to localhost:8080/checkout.

Once the page has loaded, you need to change the call to be a post method. 
You also need to change the Headers to be:
Accept: application/json
Content-Type: application/json

The body can then accept a list of string ids from 1-4:

![image](https://user-images.githubusercontent.com/36417804/206841245-422008d4-d8cd-44b9-9de7-ef949afef9b9.png)





