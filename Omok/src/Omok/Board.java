package Omok;

public class Board {
    int size;
    String[][] map;
    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }
    public void print() {
        for (int row = 0; row < size; row++) {
        	
        	if (row<10) {
        		System.out.print(" "+row);
        	}
        	else
        		System.out.print(row);
        	
        	
            for (int col = 0; col < size; col++) {
                System.out.print(" " + map[row][col]);
            }
            System.out.println();
            
        }
        System.out.print("  ");
        for (int num=65; num<84; num++) {
        	
        	System.out.print(" " + (char)num);
        }
    }
}