Shawn O'Connor implementation of famous Kwiland problem.

This program takes input from a given .txt file to build a graph representing a rail system.
it will allow the user to then run a series of methods to extract various rout information.

The program allows for Dynamic Rail system generation based on text file. However, your .txt file must contain a single
unbroken line of characters consisting of A-Z, a-z, and 0-9.

The input can be single letters or whole words starting with capitals followed by a number.

Acceptable input: AB2, AtlantaBrooklyn30, AtlantaB2, ABrooklyn1234

TO RUN:
(in Command Line enter the following) **Program Uses gradle**
- cd your_directory_path/ShawnOconnorTrainsJava
- gradle execute

**note**
When entering your file extension it is important to include directory path. For the included input
it would be as follows "./input.txt" or "./input2.txt"

TO RUN TESTS:
(in Command Line enter the following)
- gradle clean
- gradle test
