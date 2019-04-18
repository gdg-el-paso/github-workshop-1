
/*
 * GDG El Paso Github Workshop
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 15 April 2019
 */

import java.io.*;          //For fileReader() & bufferedReader()
import java.util.*;        //For scanner when TA executes .jar file

public class AITreeSearches {
	
	public static final long startTime = 0;
	public static int children_expanded = 0;        //Counter for the number of expanded successor nodes
	public static int memory_nodes = 0;             //Counter for our nodes in memory
	public static int[] goal;
	public static int[] start;

	/**
	 * GENERATE MAP SPACE
	 * This method reads the test case text file
	 * @return int[][] the 2D Map Space.
	 */
	public static int[][] generate_map_space(String filename) {
		try{
            FileReader file_reader = new FileReader(filename);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String current_line;
            
            //Get Map size
            current_line = buffered_reader.readLine();//gets the size of the map and creates the matrix for it
            String[] string_split = current_line.split(" ");
			int[][] map_space = new int[Integer.parseInt(string_split[0])][Integer.parseInt(string_split[1])];
            
			//Get Starting Position
			current_line = buffered_reader.readLine();
			string_split = current_line.split(" ");
            start = new int[]{Integer.parseInt(string_split[0]), Integer.parseInt(string_split[1])};
            
            //Get Goal Position
            current_line = buffered_reader.readLine();
            string_split = current_line.split(" ");
            goal = new int[]{Integer.parseInt(string_split[0]), Integer.parseInt(string_split[1])};
            
			int row = 0;
			System.out.println("Map Size: "+ map_space.length+ " " + map_space[0].length);
			System.out.println("Starting Position: " +start[0]+ " " +start[1]);
			System.out.println("Goal Position: " +goal[0]+ " " +goal[1]);
			
			//Create + Populate the Map Space
            while((current_line = buffered_reader.readLine()) != null) {
            	string_split = current_line.split(" ");
                for(int column=0; column<string_split.length; column++) {
                	map_space[row][column] = Integer.parseInt(string_split[column]);
                }
                row++;
            }
            //Prevent Leakage + Return Map Space
    		buffered_reader.close();
            return map_space;
        }
		catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }	
	
	/**
	 * PRINT SEARCH RESULTS
	 * @param times_up
	 * @param start_timer
	 */
	public static void print_search_Results(boolean times_up, long start_timer) {//prints results of search
		if(!(times_up)) {
			System.out.println("\tNumber of Nodes Expanded:\t\t" +children_expanded);
			System.out.println("\tMaximum Number of Nodes held in Memory:\t" + memory_nodes);
			System.out.println("\tTime of Execution (in ms):\t\t" + (System.currentTimeMillis() - start_timer));
		}
		
		//Our search timed out
		else {
			System.out.println("Null");
			System.out.println("\tCost of Path:\t-1");
			System.out.println("\tMaximum Number of Nodes Held in Memory:\t" +memory_nodes);
			System.out.println("\tTime of Execution (in ms):\t\t" + (System.currentTimeMillis() - start_timer));
		}
	}







//miglesias4 branch code

	/**
	 * SEARCH ALGORITHMS
	 * @param int[][] map_space the 2D map we generated
	 * This method calls the various search algorithms we're tasked with implementing.
	 */
	public static void search_algorithms(int[][] map_space) {
		breadth_first_search(map_space);
		iterative_deepening_search(map_space);
		a_star_search(map_space);
	}

	/**
	 * BREADTH-FIRST SEARCH
	 * @param int[][] map_space the 2D map we generated
	 * This method implements BFS on our tree from our text file.
	 */
	public static void breadth_first_search(int[][] map_space) {

		// TODO: IAN
	}

	/**
	 * ITERATIVE DEEPENING SEARCH
	 * @param int[][] map_space the 2D map we generated
	 * This method implements IDS on our tree from our text file.
	 */
	public static void iterative_deepening_search(int[][] map_space) {

		// TODO: Matt
	}

	/**
	 * A* SEARCH
	 * @param int[][] map_space the 2D map we generated
	 * This method implements A* Search on our tree from our text file.
	 */
	public static void a_star_search(int[][] map_space) {

		// TODO: NICK

	}












	
	public static void confirm_program_termination() {
		System.out.println("\nCongrats! Your program has finished executing!");
	}


	/** HELPER METHODS FOR SEARCH ALGORITHMS 												*/

	//sets the visited matrix all to false
	/**
	 * SET VISITED NODES TO FALASE
	 * @param boolean[][] nodes_visited the nodes already explored
	 * Sets the visited nodes in 2D Map Space to false
	 */  
	public static void falsify_visited_nodes(boolean[][] nodes_visited) {
		for(int i=0; i<nodes_visited.length; i++)
			for(int j=0; j<nodes_visited[i].length; j++)
				nodes_visited[i][j] = false;
	} 

	/**
	 * GOAL NODE CHECKER
	 * @param Node current_node the node we're currently at in the tree
	 * @return boolean indicates if we've reached our goal node
	 */  
	public static boolean is_goal_node(Node current_node) {
		if(current_node.distance == 0)
			return true;
		else
			return false;
	}

	/**
	 * MANHATTAN DISTANCE
	 * This method calculates and @return the Manhattan Distance.
	 * @param x the row in the matrix
	 * @param y the column in the matrix
	 * @param goal_node our goal node
	 */  
	public static int manhattan_distance(int x, int y, Node goal_node) {
		return(Math.abs(goal_node.x - x) + Math.abs(goal_node.y - y));
	}
	
	/**	Comparator For A* Search Priority Queue	 */
	public static Comparator<Node> queue_comparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
            return (int) (n1.accumulated_path_cost - n2.accumulated_path_cost);//using cost so far and comparator
        }
	};

	/**
	 * GENERATE SUCCESSOR NODES
	 * @param node current the current node being traversed
	 * @param path_cost the cost of the path thus far
	 * This method prints the path & cost from the goal node to the start node
	 */
	// public static Node[] generate_successor_nodes(Node current_node, Node goal_node, boolean[][] nodes_visited, int[][] map_space) {

	// 	//We can only move UP, DOWN, LEFT, & RIGHT
	// 	LinkedList<Node> children_nodes_LL = new LinkedList <Node> ();

	// 	//Move Right
	// 	if(current_node.y + 1 < map_space[0].length && map_space[current_node.x][current_node.y + 1] != 0 && !nodes_visited[current_node.x][current_node.y + 1]){
	// 		children_nodes_LL.add(new Node(current_node.x, current_node.y + 1, manhattan_distance(current_node.x, current_node.y + 1, goal_node), current_node.accumulated_path_cost+ map_space[current_node.x][current_node.y + 1], current_node));
	// 		nodes_visited[current_node.x][current_node.y + 1] = true;
	// 	}
	// 	//Move Left
	// 	if(current_node.y - 1 >= 0 && map_space[current_node.x][current_node.y - 1] != 0 && !nodes_visited[current_node.x][current_node.y - 1]){
	// 		children_nodes_LL.add(new Node(current_node.x, current_node.y - 1, manhattan_distance(current_node.x, current_node.y - 1, goal_node), current_node.accumulated_path_cost + map_space[current_node.x][current_node.y - 1], current_node));
	// 		nodes_visited[current_node.x][current_node.y - 1] = true;
	// 	}
	// 	//Move Up
	// 	if(current_node.x - 1 >= 0 && map_space[current_node.x - 1][current_node.y] != 0 && !nodes_visited[current_node.x - 1][current_node.y]){
	// 		children_nodes_LL.add(new Node(current_node.x - 1, current_node.y, manhattan_distance(current_node.x - 1, current_node.y, goal_node), current_node.accumulated_path_cost + map_space[current_node.x - 1][current_node.y], current_node));
	// 		nodes_visited[current_node.x - 1][current_node.y] = true;
	// 	}
	// 	//Move Down
	// 	if(current_node.x + 1 < map_space.length && map_space[current_node.x + 1][current_node.y] != 0 && !nodes_visited[current_node.x + 1][current_node.y]){
	// 		children_nodes_LL.add(new Node(current_node.x + 1, current_node.y, manhattan_distance(current_node.x + 1, current_node.y, goal_node), current_node.accumulated_path_cost + map_space[current_node.x + 1][current_node.y], current_node));
	// 		nodes_visited[current_node.x + 1][current_node.y] = true;
	// 	}
	// 	Node[] children = new Node[children_nodes_LL.size()];
	// 	return children_nodes_LL.toArray(children);
	// }

	/** MAIN RUNNER */
	public static void main(String[] args) {
		int[][] map_space = generate_map_space((args[0]));
		search_algorithms(map_space);
		confirm_program_termination();
	}
}
