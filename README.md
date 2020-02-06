# Maze
This code is using Stack and recursive function for finding a path in the input maze.
## General steps
At first getting the number of rows and columns from input and read the Maze map from **position.txt** file.  
_(Enter 6 for the row and column number, because the default position file has 6 rows and columns. by changing the position.txt file with desired number of rows and columns you can enter that numbers in the input)_

Then by calling recursive function **findPath** and using two instances of stack (one for rows and another for columns), print the path from start point (top left) to the end point (bottom right).
