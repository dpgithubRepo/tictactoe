package experiments;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	static String[] board = new String[9];
	static String winner = null;
	static String currentSymbol = "X";
	static int moveCount = 0;

	static void displayBoard() {
		System.out.println("\n\n");
		System.out.println(" ------------");
		System.out.print(" | " + board[0] + " | " + board[1] + " | " + board[2] + "\n");
		System.out.println(" ------------");
		System.out.print(" | " + board[3] + " | " + board[4] + " | " + board[5] + "\n");
		System.out.println(" ------------");
		System.out.print(" | " + board[6] + " | " + board[7] + " | " + board[8] + "\n");
		System.out.println(" ------------");
	}

	static void checkWinner() {

		if (board[0] != "-" && board[0] == board[1] && board[1] == board[2]) {
			winner = currentSymbol;
			return;
		}

		if (board[3] != "-" && board[3] == board[4] && board[4] == board[5]) {
			winner = currentSymbol;
			return;
		}

		if (board[6] != "-" && board[6] == board[7] && board[7] == board[8]) {
			winner = currentSymbol;
			return;
		}

		if (board[0] != "-" && board[0] == board[3] && board[3] == board[6]) {
			winner = currentSymbol;
			return;
		}
		if (board[1] != "-" && board[1] == board[4] && board[4] == board[7]) {
			winner = currentSymbol;
			return;
		}
		if (board[2] != "-" && board[2] == board[5] && board[5] == board[8]) {
			winner = currentSymbol;
			return;
		}

		if (board[0] != "-" && board[0] == board[4] && board[4] == board[8]) {
			winner = currentSymbol;
			return;
		}

		if (board[6] != "-" && board[6] == board[4] && board[4] == board[2]) {
			winner = currentSymbol;
			return;
		}

	}

	public static void main(String[] args) {

		Arrays.fill(board, "-");
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Welcome to tictactoe game... first player symbol will be 'X' & second player symbol will be 'O'");
		displayBoard();
		
		
		
		

		while (winner == null && moveCount < 9) {

			System.out.println("Select the Spot for " + currentSymbol);
			int spot = scanner.nextInt();
			
			while(spot < 1 || spot > 9) {
				System.out.println("spot can only be between 1 & 9. " + spot + " is invalid entry. ");
				spot = scanner.nextInt();
			}
			
			while (board[spot - 1] != "-") {
				System.out.println("spot is already taken. select new spot for " + currentSymbol);
				spot = scanner.nextInt();
			}
			board[spot - 1] = currentSymbol;
			checkWinner();
			if (winner != null) {
				System.out.println("**** WE HAVE A WINNER ****");
				System.out.println("Game won by " + currentSymbol);
				displayBoard();
				break; //we have a winner nothing to be done after this point
			}
			currentSymbol = currentSymbol == "X" ? "O" : "X";
			displayBoard();
			moveCount++;
		}

		if (moveCount == 9 && winner == null) {
			System.out.println("Game Tie !!");
		}

		scanner.close();
	}

}
