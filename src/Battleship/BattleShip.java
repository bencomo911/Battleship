package Battleship;
import java.util.Scanner;

public class BattleShip {
	static int n = 9;//used to create nxn grid
	static boolean cornerCell = false;
	static boolean first_Row = false;
	static boolean last_Row = false;
	static boolean first_Column = false;
	static boolean last_Column = false;
	
	
	public static void cell_detection(int row, int column) {
		
		if(row == 0 || row == n && column == 0 || column == n) { //detects a corner cell 
			cornerCell = true;
		}
		else if(row == 0) {
			first_Row = true;
		}
		else if(row == n) {
			last_Row = true;
		}
		else if(column == 0) {
			first_Column = true;
		}
		else if(column == n) {
			last_Column = true;
		}
	}
	
	/*********************** Data-Printing ******************************/
	public static void top_neighbor(int x, int y){
		System.out.println("[" + x + "," + (y+1) + "]" );
	}
	
	public static void bottom_neighbor(int x, int y) {
		System.out.println("[" + (x) + "," + (y-1) + "]");
	}
	
	public static void right_neighbor(int x, int y) {
		System.out.println("[" + (x+1) + "," + y + "]");
	}
	
	public static void left_neighbor(int x, int y) {
		System.out.println("[" + (x-1) + "," + y + "]");
	}
	
	/*******************************************************************/
	
	
	public static void edge_cases(int x, int y){ //takes care of edge cases
		
		/*************** corner edge-cases *******************/
		if(cornerCell == true) { //corner cases
			if(x == 0 && y == 0) {
				top_neighbor(x,y);
				right_neighbor(x,y);
			}
			
			if(x == 0 && y == n) {
				bottom_neighbor(x,y);
				right_neighbor(x,y);
			}
			
			if(x == n && y == 0) {
				top_neighbor(x,y);
				left_neighbor(x,y);
			}
			
			if(x == n && y == n) {
				bottom_neighbor(x,y);
				left_neighbor(x,y);
			}
		}
		/*****************************************************/
		
		/*************** first row edge-cases *******************/
		if(first_Row == true) {
			
			
		}
		/*****************************************************/
	}
	
	public static void edges(int x, int y) {
		
		if(cornerCell == true) {
			edge_cases(x, y);
		}
		
	}

	public static void main(String [] args) {
		
		
		int [][] grid = new int [n][n]; //Create nxn grid
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter current coordinate separated by a space: ");
		
		
		String[] coordinate = sc.nextLine().split(" "); //Create array with given coordinates
		int row =  Integer.parseInt(coordinate[0]); //Convert input to integer
		int column = Integer.parseInt(coordinate[1]);
		sc.close();
		
	
		cell_detection(row, column);//updates object parameters appropriately 
		System.out.println("edge-adjacent squares: ");
		edges(row, column);
		
		
		
	}
}
