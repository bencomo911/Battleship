package Battleship;
import java.util.Scanner;

public class BattleShip {
	static int n = 9;//used to create nxn grid
	
	public static void corner_edges(int x, int y){
		
		if( x == 0 && y == 0 || x == 0 && y == n || x == n && y == 0 || x == n && y == n) { //corner cases
			if(x == 0 && y == 0) {
				System.out.println("edge-adjacent: [" + x + "," + (y+1) + "], [" + (x+1) + "," + y + "]");
				
			}
			
			if(x == 0 && y == n) {
				System.out.println("edge-adjacent: [" + x + ", " + (y-1) + ", [" + (x+1) + "," + y + "]");
			}
			
			if(x == n && y == 0) {
				System.out.println("edge-adjacent: [" + (x-1) + "," + y + "], [" + (x) + "," + (y+1) + "]");
			}
			
			if(x == n && y == n) {
				System.out.println("edge-adjacent: [" + (x-1) + "," + y + "], [" + (x) + "," + (y-1) + "]");
			}
		}
		
	}
	
	public static void edges(int x, int y) {
		
		
		
	}

	public static void main(String [] args) {
		
		
		int [][] grid = new int [n][n]; //Create nxn grid
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter current coordinate separated by a space: ");
		
		
		String[] coordinate = sc.nextLine().split(" "); //Create array with given coordinates
		int row =  Integer.parseInt(coordinate[0]); //Convert input to integer
		int column = Integer.parseInt(coordinate[1]); 
		
		corner_edges(row, column);
		
		
		
		
		for(int i = 0; i < 2; i++) { //iterate through input 
			
		}
	}
}
