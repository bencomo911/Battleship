package Battleship;
import java.util.Scanner;

public class BattleShip {
	static int n = 9;//used to create nxn grid
	static boolean cornerCell = false;
	static boolean first_Row = false;
	static boolean last_Row = false;
	static boolean first_Column = false;
	static boolean last_Column = false;
	static int [][] existing_squares = new int [n][n]; 
	
	
	public static void populate_squares(int x, int y) { //adds touched cells into grid
		existing_squares[x][y] = -1;
	}
	
	
	//detects if specified cell is a special case such as a corner or first or last row/column
	public static void cell_detection(int row, int column) { 
		
		if((row == 0 || row == n-1) && (column == 0 || column == n-1)) { //detects a corner cell 
				cornerCell = true;
		}
		
		else if(row == 0) {

			first_Row = true;
		}
		else if(row == n-1) {
			last_Row = true;
		}
		else if(column == 0) {
			first_Column = true;
		}
		else if(column == n-1) {
			last_Column = true;
		}
	}
	
	/*********************** Data-Printing Methods ******************************/
	public static void top_neighbor(int x, int y){
		x = x+1;
		System.out.println("[" + (x) + "," + (y) + "]" );
		populate_squares(x,y);
		
	}
	
	public static void bottom_neighbor(int x, int y) {
		if(x > 0) {
			x-=1;
		}
		
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void right_neighbor(int x, int y) {
		y = y+1;
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void left_neighbor(int x, int y) {
		if(y > 0) {
			y-=1;
		}
		System.out.println("[" + (x) + "," + y + "]");
		populate_squares(x,y);
	}
	
	public static void top_right_diagonal(int x, int y) {
		x = x+1;
		y = y+1;
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void top_left_diagonal(int x, int y) {
		x = x-1;
		y = y-1;
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void bottom_right_diagonal(int x, int y) {
		x = x-1;
		y = y+1;
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void bottom_left_diagonal(int x, int y) {
		x = x-1;
		y = y-1;
		System.out.println("[" + (x) + "," + (y) + "]");
		populate_squares(x,y);
	}
	
	public static void untouched_squares(int [][] grid) {
		
		for(int row = 0; row < n; row++) {
			for(int column = 0; column < n; column++) {
				if(grid[row][column] != -1) {
					System.out.println("[" + (row) + "," + (column) + "]");
				}
			}
		}
		
	}
	
	/*******************************************************************/
	
	
	public static void edge_cases(int x, int y){ //takes care of edge cases for edge-adjacent squares
		
		/*************** corner edge-cases *******************/
		if(cornerCell == true) { //corner cases
			if(x == 0 && y == 0) {
				top_neighbor(x,y);
				right_neighbor(x,y);
			}
			
			else if(x == 0 && y == n-1) {
				top_neighbor(x,y);
				left_neighbor(x,y);
			}
			
			else if(x == n-1 && y == 0) {
				bottom_neighbor(x,y);
				right_neighbor(x,y);
			}
			
			else if(x == n-1 && y == n-1) {
				bottom_neighbor(x,y);
				left_neighbor(x,y);
			}
		}
		/*****************************************************/
		
		/*************** first row edge-cases *******************/
		if(first_Row == true) {
			top_neighbor(x,y);
			right_neighbor(x,y);
			left_neighbor(x,y);
			
		}
		/*****************************************************/
		
		/*************** last row edge-cases *******************/
		if(last_Row == true) {
			bottom_neighbor(x,y);
			right_neighbor(x,y);
			left_neighbor(x,y);
			
		}
		/*****************************************************/
		
		/*************** first column edge-cases *******************/
		if(first_Column == true) {
			top_neighbor(x,y);
			bottom_neighbor(x,y);
			right_neighbor(x,y);
		
			
		}
		/*****************************************************/
		
		/*************** last column edge-cases *******************/
		if(last_Column == true) {
			top_neighbor(x,y);
			bottom_neighbor(x,y);
			left_neighbor(x,y);
		
			
		}
		/*****************************************************/
	}
	
	public static void edges_adjacent_squares(int x, int y) { //lists all edge_adjacent squares
		
		if(cornerCell == true || first_Row == true || first_Column == true || last_Row == true || last_Column == true) {
			edge_cases(x, y);
		}
		else {
			top_neighbor(x,y);
			bottom_neighbor(x,y);
			right_neighbor(x,y);
			left_neighbor(x,y);
		}
		
	}
	
	public static void corner_adjacent_special_cases(int x, int y){ //takes care of edge cases for corner-adjacent squares
		
		/*************** corner edge-cases *******************/
		if(cornerCell == true) { //corner cases
			if(x == 0 && y == 0) {
				top_right_diagonal(x,y);
			}
			
			else if(x == 0 && y == n-1) {
				top_left_diagonal(x,y);
			}
			
			else if(x == n-1 && y == 0) {
				bottom_right_diagonal(x,y);
			}
			
			else if(x == n-1 && y == n-1) {
				bottom_left_diagonal(x,y);
			}
		}
		/*****************************************************/
		
		/*************** first row edge-cases *******************/
		if(first_Row == true) {
			top_right_diagonal(x,y);
			top_left_diagonal(x,y);
			
		}
		/*****************************************************/
		
		/*************** last row edge-cases *******************/
		if(last_Row == true) {
			bottom_right_diagonal(x,y);
			bottom_left_diagonal(x,y);
			
		}
		/*****************************************************/
		
		/*************** first column edge-cases *******************/
		if(first_Column == true) {
			top_right_diagonal(x,y);
			bottom_right_diagonal(x,y);
		
			
		}
		/*****************************************************/
		
		/*************** last column edge-cases *******************/
		if(last_Column == true) {
			top_left_diagonal(x,y);
			bottom_left_diagonal(x,y);
			
		}
		/*****************************************************/
	}
	
	public static void corners_adjacent_squares(int x, int y) { //lists all corner_adjacent squares
		
		if(cornerCell == true || first_Row == true || first_Column == true || last_Row == true || last_Column == true) {
			corner_adjacent_special_cases(x, y);
		}
		else {
			top_right_diagonal(x,y);
			bottom_right_diagonal(x,y);
			top_left_diagonal(x,y);
			bottom_left_diagonal(x,y);
		}
		
	}
	
	public static void non_adjacent_special_cases(int x, int y) {
		
		/*************** corner edge-cases *******************/
		if(cornerCell == true) { //corner cases
			if(x == 0 && y == 0) {
				int constant = 2;
				for(int i = 0; i < 9; i++ ) {
					System.out.println();
				}
			}
			
			else if(x == 0 && y == n-1) {
				top_left_diagonal(x,y);
			}
			
			else if(x == n-1 && y == 0) {
				bottom_right_diagonal(x,y);
			}
			
			else if(x == n-1 && y == n-1) {
				bottom_left_diagonal(x,y);
			}
		}
		/*****************************************************/
		
	}
	
	public static void non_adjacent_squares(int x, int y) { //takes care of non-adjacent squares
		
		if(cornerCell == true) {
			
		}
		
	}

	public static void main(String [] args) {
		
		populate_squares(0, 0);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter current coordinate separated by a space: ");
		
		
		String[] coordinate = sc.nextLine().split(" "); //Create array with given coordinates
		int row =  Integer.parseInt(coordinate[0]); //Convert input to integer
		int column = Integer.parseInt(coordinate[1]);
		sc.close();
		
	
		cell_detection(row, column);//updates object parameters appropriately 
		
//		System.out.println("corner: " + cornerCell);
//		System.out.println("LastRow: " + last_Row);
//		System.out.println("firstRow: " + first_Row);
//		System.out.println("firstCol: " + first_Column);
//		System.out.println("lastCol: " + last_Column);
		
		System.out.println("\nedge-adjacent squares: ");
		edges_adjacent_squares(row, column);
		System.out.println("\ncorner-adjacent squares: ");
		corners_adjacent_squares(row,column);
		
		System.out.println("\nnon-adjacent squares: ");
		untouched_squares(existing_squares);
		
	}
}
