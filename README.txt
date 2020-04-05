Object Orientation with Design Patterns Project


April 2020 Lecturer: Amilcar Aponte

Assignment Introduction

You have been provided with access to a real database server that contains only one table (country),
and have been tasked to develop a Java program in charge of:

• Retrieve all records stored in the database table
• Retrieve records by country name
• Retrieve records by country code
• Add new records into the database

Specific Requirements

• You are required to implement the Data Access Object pattern, in combination with any
other two creational patterns of your choice.
• You also have to create a simple CLI client program to test your implementation of the
patterns.

o The client program should not have any direct contact with the database and should
pass and receive data in the form of objects (instances of a Country class).

o The client program must present the user with a menu with the following options

▪ List all countries in the database
▪ Find a country by country code
▪ Find a country by name
▪ Save a new country in the database

The Builder Pattern has been used in order to work on the following advantages it has:

▪ It provides clear separation between the construction and representation of an object.
▪ It provides better control over construction process.
▪ It supports to change the internal representation of objects.