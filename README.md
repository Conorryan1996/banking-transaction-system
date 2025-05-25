Banking Transaction System

A microservices-based banking platform built with Spring Boot. Designed with purpose of enhancing my knowledge
on microservice architecture. The project is designed with scalability and security in mind. Below are a list of the
main technologies used and the purpose of each

    - PostGres: Provides the back-end persistent database storage for the microservices
    - gRPC: Used to communicate between the accounting services 

The project implements a typical banking transaction system using microservice architecture. The below are each
of the services and a short summary of the purpose of each:

Account Service (Port 5000) 
The Account Service serves as the starting point for the system. The following functionalities are catered to by this
system:

    -  Create new accounts with Unique UUID account number generation.
    -  Retrieve account information and balances
    -  Update account status (Active, Inactive, Frozen, Closed)
    -  Customer account relationships






























