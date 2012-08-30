//var input = Console.readLine
//Console.println(input)

class XO ()
{

	var board  = new Array[String](9)
	board(0) = "_"
	board(1) = "_"
	board(2) = "_"
	board(3) = "_"
	board(4) = "_"
	board(5) = "_"
	board(6) = "_"
	board(7) = "_"
	board(8) = "_"
			   
	def winner(one: String, two: String, three: String):Boolean =
	{
		if((one + two + three) == "XXX")
		{
			Console.println("X wins!")
			return true
		}	
		else if((one + two + three) == "OOO")
		{
			Console.println("O wins!")
			return true
		}
		return false
	}
	
	def turn(player: String, space: Int) :Boolean =
	{
		if(board(space) == "_")
		{
			board(space) = player
			return true
		}
		else
		{
			Console.println("That space is already occupied")
			return false
		}
	}
	def checkForWinnerRow(one:Int, two:Int, three:Int) :Boolean =
	{
		return winner(board(one),board(two),board(three))
	}
	def checkForWinner() :Boolean =
	{
		if(checkForWinnerRow(0,1,2) || checkForWinnerRow(3,4,5) || checkForWinnerRow(6,7,8) ||
			checkForWinnerRow(0,3,6) || checkForWinnerRow(1,4,7) || checkForWinnerRow(2,5,8) ||
			checkForWinnerRow(0,4,8) || checkForWinnerRow(2,4,6))
		{
			return true
		}
		return false
	}
	
	def prettyPrintBoard()
	{
		Console.println("---------")
		Console.println("["+board(0)+"]["+board(1)+"]["+board(2)+"]")
		Console.println("["+board(3)+"]["+board(4)+"]["+board(5)+"]")
		Console.println("["+board(6)+"]["+board(7)+"]["+board(8)+"]")
		Console.println("---------")
	}
}

val test = new XO()
var turn = 0
while(!test.checkForWinner)
{
	test.prettyPrintBoard
	var space = 0
	if(turn%2 == 0)
	{
		do
		{
			Console.println("It is X's turn. What space do you want X?")
			space = Console.readLine.toInt
		}
		while(!test.turn("X",space))
	}
	else
	{
		do
		{
			Console.println("It is O's turn. What space do you want X?")
			space = Console.readLine.toInt
		}
		while(!test.turn("O",space))
	}
	
	turn += 1
}
test.prettyPrintBoard