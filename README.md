##Database Benchmarking Project - 
CS 487/587 Database Implementation
By: Jetha Harsha and Janaki Raghuram Srungavarapu 

## Brief Description:
The project aims to evaluate a single system (postgres) with different parameter values and optimizer options. The database is evaluated with the help of benchmark comparisons using queries from Wisconsin Benchmark. 
(http://jimgray.azurewebsites.net/benchmarkhandbook/chapter4.pdf)

##Part -1 of the project
The objective of this part 1 of the project is to generate data based on the Wisconsin Benchmark specification. Three data files (onektup, tenktup1 and tenktup2) are generated using a Java language based script – Generator.java. The Generated data files are placed in folder named ‘Generated files’.

## Important File descriptions:
The main files are in the directory "src/com/dbimpl". The "Genrator.java" file generates the data based on based on the Wisconsin Benchmark specification. The files also has the configuration for postgres connections.
The generated data files are in the csv format. These files are loaded into Generated files folder

## System choice
We plan to develop a benchmark comparisons using queries from Wisconsin Benchmark and evaluate against a progress system. We chose to evaluate a single database system as we felt it is easy keep the other parameters (such as OS load, processor speed, main memory availability) constant while testing the database against different parameter values and optimizer options. 
PostgreSQL is chosen because of availability of rich documentation. We also have access to college PostgreSQL from our previous Introduction to Database Management class. 
For data generation we considered writing code in Python vs Java. Since one of us is more comfortable with Java we chose to use Java. 


## Lessons learnt / Problems encountered: 

