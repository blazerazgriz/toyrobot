Toy Robot Simulator Read Me
===========================
Requirements
------------
1. Java 1.7
2. Junit
3. Maven for handling project dependencies and compilation

Description
------------
The following code was developed in response to the PROBLEM.md file provided by REA.
The requirements were to:
1. Create a command line based application that simulates a robot on a table top
2. The valid commands are:
  a. PLACE X,Y,F
    - X determines the initial X position of the Robot
    - Y determines the initial Y position of the Robot
    - F determines the facing direction of the robot. The valid values for F are
      * NORTH | SOUTH | EAST | WEST
  b. MOVE
    - Moves the Robot forward by 1 block depending on the direction it is facing.
  c. LEFT
    - Rotates the robot's Facing Direction to the left
  d. RIGHT
    - Rotates the robot's Facing Direction to the right
  e. REPORT
    - Prints the current position of the robot on the table in the following format
      * X,Y,F 
      * ex. 0,0,NORTH
3. Any Robots not placed on the table top can ignore the following commands:
  - MOVE | LEFT | RIGHT | REPORT
4. Robot must not fall off the table top
5. The MOVE command must be ignored if the Robot's next move will cause it to fall off the table.
6. 0,0 Can be determined as the SOUTH WEST Corner of the Table.

How To:
------------
COMPILE
  - Use the following maven command to compile:
    mvn compile

TEST
  - Use the following maven command to execute the Junit test within the project
    mvn test

EXECUTE
  - Use the following maven command to execute the project
    mvn exec:java

PACKAGING
  - Use the following maven command to package the project into a jar.
  - The compiled jar can be found within the target/ folder of the project
    mvn package
