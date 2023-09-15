package Omok;

import java.util.*;

public class Omok {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
        Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, user, computer);
    }
    private static void play(Board board, Player user, Player computer) {
        board.print();
        System.out.println();
        
        System.out.print("사용자> ");
       
    }
}