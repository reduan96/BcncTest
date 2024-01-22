
# Hexagonal Architecture Test

Bcnc technical test that consist about developing GET request to see wich fee is going to be apply to some products and it gives us final price.
I did it on Hexagonal Architecture (Ports and Adapters Architecture). Its an Architecture that focus at DDD(Domain Driven Design) where our Domain is the center of our application and every layer is independent from another. I will give scheme that i created to understand it.



## Hexagonal Architecture Scheme
![ArqHex](https://github.com/reduan96/HexArqTest/assets/45995667/b04e3fb2-5b73-4220-b88b-0b490c30a49d)

## Prerequisites

- Your favourite IDE
- JAVA 17

## Installation

- Install your favourite IDE (Mine is IntelliJ Community !)
- download or clone the project and import it in your IDE
- It runs under JAVA 17
## Usage

- download or clone the project and import it in your IDE
- mvn clean install to compile it
- Run it like java app in your IDE (if you want, you can run the tests run tests in your IDE)
- When the app is running OK go to your browser and put http://localhost:9090/h2-console and its going to appear the h2 console.
- go to the terminal and look for the line H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
- you enter the previous line in the JDBC URL field: jdbc:h2:mem:testdb
- go to application.properties and youre going to see the user and password, put them at h2 console and press to get inside.
- Now you can see via SQL queries the H2 database that we have embedded in our project everytime when we run the project.
- To test the GET request that we have, you can test it at the browser or for example at postman or vs code extension named Thunder client. You can test with the following example http://localhost:8080/prices/getAppliedPrice/2020-06-14T10:00:00/35455/1
## Contributing

Redouan - redu1996@gmail.com (Me)
## Contact

You can contact me via email redu1996@gmail.com or via Linkedin (I have it on my Github profile) :D