import java.util.Scanner;
public class ConnectFour
{
	final public static char[][] board = new char[6][7];
		
	public static void main(String[] args)
	{
		int column = 0;
		char color = 0;
		boolean winner = false;
		int playAgain = 1;
		Scanner input = new Scanner(System.in);
		do 
		{
			//This for loop initializes the array
			for (int row = 0; row < board.length; row++)
			{
				for (int col = 0; col < board[0].length; col++)
				{
					board[row][col] = ' ';
				}
			}
			
			dropDisk(board,column,color);
			winner = isWinner(board,color);
		} while (winner == false && playAgain == 1);
		
		if (winner == true)
		{
			System.out.println("New Game? 0 for NO, 1 for YES");
			playAgain = 0;
			playAgain = input.nextInt();
			if (playAgain == 1)
			{
				winner = false;
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
		//boolean validPlay = false;
		Scanner input = new Scanner(System.in);
		boolean winner = false;
		//Checks to see if the play is valid before taking the user input into the next loop.
		while(winner == false && turn <= 42)
		{
			boolean validPlay = false;
			
			//This loop calls in the columnIsFull method. If the column is determined to be invalid or full, validPlay will be false, and thus this loop will continue.
			do
			{
				printBoard(board);
				//play is a variable that represents a user input of which column they would like to drop the disk into.
				play = input.nextInt();
				validPlay = columnisFull(board,play);
			
			} while (validPlay == false);
				
				//This for loop is designed to drop 
				for (int row = board.length - 6; row >= 0; row++)
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
				
				if (turn == 43)
				{
					System.out.println("Tie Game");
				}
				
	
		}
		//If a player meets one of the win conditions, then the board 
		if (winner == true)
		{
			if (color == 'R')
			{
				printBoard(board);
				System.out.println("Yellow Player Wins");
			}
				
			else if (color == 'Y')
			{
				printBoard(board);
				System.out.println("Red player wins");	
			}
		}
	}
	
	private static boolean isWinner(char[][] board, char color)
	{
		//Checks for a winner with a four-across win condition
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length - 3; col++)
			{
				if (board[row][col] == board[row][col + 1] && board[row][col + 1] == board[row][col + 2] && board[row][col + 2] == board[row][col +3])
				{
					if (board[row][col] == 'R' || board[row][col] == 'Y')
					{
						return true;
					}
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
					if (board[row][col] == 'R' || board[row][col] == 'Y')
					{
						return true;
					}
				}
			}
		}
		
		//Checks for a forwards diagonal win condition
		for (int row = 0; row < board.length - 3; row++)
		{
			for (int col = 0; col < board.length - 3; col++)
			{
				if (board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3])
				{
					if (board[row][col] == 'R' || board[row][col] == 'Y')
					{
						return true;
					}
				}
			}
		}
		
		//Checks for a backwards diagonal win condition
		for (int row = 3; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length - 3; col++)
			{
				if (board[row][col] == board[row - 1][col + 1] && board[row][col] == board[row - 2][col + 2] && board[row][col] == board[row - 3][col + 3])
				{
					if (board[row][col] == 'R' || board[row][col] == 'Y')
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean columnisFull(char[][] board, int col)
	{
		 /* Checks the board and tells the user if the column is either an invalid number or full. If it is invalid, it returns false, otherwise,
		 it returns true. */
			if (col < 0 || col > board[0].length || board[5][col] != ' ')
			{
				System.out.println("INVALID OR FULL COLUMN: PLEASE CHOOSE ANOTHER COLUMN");
				return false;
			}
			return true;
	}
}


		 
	