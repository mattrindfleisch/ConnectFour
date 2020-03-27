import java.util.*;
public class ConnectFour
{
	final public static char[][] board = new char[6][7];
		
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		printBoard(board);
		
		//This for loop initializes the array
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				board[row][col] = ' ';
			}
		}
	}
	private static void printBoard(char[][] board)
	{
		for(int i = board.length - 1; i >= 0; i--)
		{
			System.out.print("| ");
			for(int j = 0; j <board[i].length; j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	private static void dropDisk(char[][] board, int column, char color)
	{
		int turn = 1;
		color = 'R';
		int play = 0;
		boolean validPlay = false;
		Scanner input = new Scanner(System.in);
		boolean winner = false;
		
		//Checks to see if the play is valid before taking the user input into the next loop.
		while(winner == false && turn <= 42)
		{
			while (validPlay == false)
			{
				play = input.nextInt();
				validPlay = columnisFull(board,play);
			
			}
			
		
			for (int row = board.length - 1; row >= 0; row--)
			{
				if (board[row][play] == ' ')
				{
					board[row][play] = color;
					break;
				}
			}
		
			//Switches player's turn. If the disk that was just dropped was red, then the next turn is yellow, and vice versa.
			if (color == 'R')
			{
				color = 'Y';
			}
			
			else if (color == 'Y')
			{
				color = 'R';
			}
			
			//Calls the isWinner method to determine if there is a winner. If a winner is found, then the game stops.
			winner = isWinner(board, color);
			
			//Increments the turn
			turn++;
		}
		
		if (winner == true)
		{
			if (color == 'R')
			{
				System.out.println("Red player wins");
				break;
			}
			
			else if (color == 'Y')
			{
				System.out.println("Yellow player wins");
				break;
			}
		}
		
		if (turn == 43)
		{
			System.out.println("Tie game");
			break;
		}
	}
	
	private static boolean isWinner(char[][] board)
	{
		//Checks for a winner with a four-across win condition
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length - 3; col++)
			{
				if (board[row][col] == board[row][col + 1] && board[row][col + 1] == board[row][col + 2] && board[row][col + 2] == board[row][col +3])
				{
					return true;
				}
			}
		}
		//Checks for a winner with a vertical win condition.
		for (int row = 0; row < board.length - 3; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				if (board[row][col] == board[row + 1][col] && board[row + 1][col] == board[row + 2][col] && board[row + 2][col] == board[row + 3][col])
				{
					return true;
				}
			}
		}
		//Checks for a backwards diagonal win condition
		for (int row = 0; row < board.length - 3; row++)
		{
			for (int col = 0; col < board.length - 3; col++)
			{
				if (board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3])
				{
					return true;
				}
			}
		}
		
		//Checks for a forwards diagonal win condition
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length - 3; col++)
			{
				if (board[row][col] == board[row - 1][col + 1] && board[row][col] == board[row - 2][col + 2] && board[row][col] == board[row - 3][col + 3])
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean columnisFull(char[][] board, int col)
	{
		 /* Checks the board and tells the user if the column is either an invalid number or full. If it is invalid, it returns false, otherwise,
		 it returns true. */
		if (board[0][col] != ' ' || col < 0 || col > board[0].length)
		{
			System.out.println("INVALID OR FULL COLUMN: PLEASE CHOOSE ANOTHER COLUMN");
			return false;
		}
		return true;
	}
}


		 
	