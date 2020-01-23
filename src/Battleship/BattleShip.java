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
		System.out.println("cellDetection " + row + " " + column);
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
		System.out.println("[" + (x+1) + "," + (y) + "]" );
	}
	
	public static void bottom_neighbor(int x, int y) {
		if(x > 0) {
			x-=1;
		}
		System.out.println("[" + (x) + "," + (y) + "]");
	}
	
	public static void right_neighbor(int x, int y) {
		System.out.println("[" + (x) + "," + (y+1) + "]");
	}
	
	public static void left_neighbor(int x, int y) {
		if(y > 0) {
			y-=1;
		}
		System.out.println("[" + (x) + "," + y + "]");
	}
	
	/*******************************************************************/
	
	
	public static void edge_cases(int x, int y){ //takes care of edge cases
		
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
	
	public static void edges(int x, int y) {
		
		if(cornerCell == true || first_Row == true || first_Column == true || last_Row == true || last_Column == true) {
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
		System.out.println("corner: " + cornerCell);
		System.out.println("LastRow: " + last_Row);
		System.out.println("firstRow: " + first_Row);
		System.out.println("firstCol: " + first_Column);
		System.out.println("lastCol: " + last_Column);
		
		System.out.println("\nedge-adjacent squares: ");
		edges(row, column);
		
		
		
	}
}
