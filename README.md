# aiV2
AI course project
In this project, we tried to reach one of the goal states from the starting point in a two-dimensional maze. The maze consists of 64 nodes in total and the nodes are of different types; normal, goal and trap. To complete this game successfully, it is our duty to reach one of the goal state from the starting point. To complete this game successfully, use the various search methods the mission of the project. Therefore, we implemented BFS, DFS, Iterative Deepening Search, Uniform Cost Search, Greedy Best First Search and A Star Search algorithms in our project. We have implemented the graph search method in all of the algorithms we use.
In order to carry out all these searches, we must first introduce the maze to our program. We have created a JSON object for each node of the maze in the JSON file for identification and enumerated to distinguish it. 
  
To create ease of operation I have checked with only one variable that position, we have not introduced as Row and Column. When writing to the terminal, we put it in row and column format.

•	BFS: Depth First Search algorithm was implemented in order to prioritize the nodes in the east, south, west and north directions. If the neighbor has the desired direction, it is added to the frontier. Linked List were used in BFS.
•	DFS: Depth First Search algorithm was implemented in order to prioritize the nodes in the east, south, west and north directions. If the neighbor has the desired direction, it is added to the frontier. Stacks were used in DFS.
•	Iterative Deepening Search: We used recursive method to arrive goal state.
•	Uniform Cost Search:Used to find best solution
•	Greedy Best First Search: We used estimated cost for goal state. Also, we used city block distance (Manhattan distance) as an admissible heuristic.
•	A Star Search: We used estimated cost for goal state with real cost to make decision. Also, we used city block distance (Manhattan distance) as an admissible heuristic.



