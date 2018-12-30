package code;

import java.util.Scanner;

public class SlotMachine {

	private static final boolean True = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//This is the introduction to the slot machine
		
		System.out.println("Welcome to the Only Casino");
		System.out.println("You have choicen slot machines");
		System.out.println("You start off with 100 coins.");
		System.out.println("Bets start at 5 coins. Max amount of coins you can bet is 100");
		System.out.println("If you get shape 1 (two eyes and a mouth) in all three spots, then you get your bet times 5");
		System.out.println("If you get shape 2 (an arrow) in all three spots, then you get your bet times 10");
		System.out.println("If you get shape 3 (a pair of glasses) in all three spots, you get your bet time 50");
		System.out.println("If you get shape 4 (a sword) in all three, you get your bet times 100");
		
		//This is to promte the user 
		System.out.println("You can play until you have 0 coins left. Do you agree? Answer yes or no.");
		String again = input.next();
		
		//This is to create how much coins the user wants to bet
		System.out.println("How much would you like to bet?");
		int bet = input.nextInt();
		
		//This is to create stuff with the ending (wins, loses, spins, etc)
		int remainingBet = 100 - bet;
		int spinCount = 0;
		int winCount = 0;
		int lostCount = 0;
		
		//The shapes 
		String shapeOne = "|_|";
		String shapeTwo = "---->";
		String shapeThree = "'o~o'";
		String shapeFour = "@xxxx[{:::::::::::::::::::::>";
		
		//This is to start the spin
		do{		
			spinCount++;
		    //To start the betting
			if ((bet >= 5) || (bet <=100)){
				int one = 999, two = 998, three = 997; // just random numbers
				String shape = "";
				for (int counter = 1; counter < 4; counter++)
				{
					int rnumber = (int) Math.rint(Math.random() * 3 + 1 );
					//This is to give three out of the four shapes a "spin"
					if(counter == 1)
					{
						one = rnumber;
					}
					else if(counter == 2)
					{
						two = rnumber;
					}
					else if(counter == 3)
					{
						three = rnumber;
					}
					//This is to create an out put for each of the shapes when Math.random generates a number
					if(rnumber == 1)
					{
						shape = shapeOne;
						System.out.println(shapeOne);
					}
					else if(rnumber == 2)
					{
						shape = shapeTwo;
						System.out.println(shapeTwo);
					}
					else if(rnumber == 3)
					{
						shape = shapeThree;
						System.out.println(shapeThree);
					}
					else if(rnumber == 4)
					{
						shape = shapeFour;
						System.out.println(shapeFour);
					}
					else
					{
						System.out.println("Wrong shape:"+rnumber);
					}
				}
				//This is if you win, and have all three shapes the same
				if((two == three) && (one == two))
				{
					winCount++;
					if (shape.equals(shapeOne)) { 
						remainingBet =((bet * 5) + remainingBet);
						System.out.println("You won!!! You have " + remainingBet + " left.");
					}
					else if (shape.equals(shapeTwo)){
						remainingBet =((bet * 10) + remainingBet);
						System.out.println("You win!!! You have " + remainingBet + " left.");
					}
					else if (shape.equals(shapeThree)){
						remainingBet = ((bet * 50) + remainingBet);
						System.out.println("You win!!! You have " + remainingBet + " left.");
					}
					else if (shape.equals(shapeFour)){
						remainingBet = ((bet * 100) + remainingBet);
						System.out.println("You win!!! You have " + remainingBet + " left.");
					}
				}
				//This is if you lose the bet or spin 
				else if((one != two) || (two != three) || (one != three)){
					lostCount++;
					System.out.println("You have " + remainingBet + " coins left");
				}
				
				//This is to play again
				if (remainingBet > 0){
					System.out.println("How much would you like to bet?");
					bet = input.nextInt();
					if(bet <= remainingBet)
					{
						remainingBet = remainingBet - bet;
					}
					else
					{
						bet = remainingBet;
						remainingBet = 0;
					}
					//This is for the total amount of betted coins
					System.out.println("You have bet " + bet);
				}
				else // no more bet remaining, get out of loop and finish game
				{
					System.out.println("You have run out of coins, thank you for playing at the Only Casino");
					//How much money the person is leaving with
					System.out.println("Your earning are " + (remainingBet -100));
					break;
				}
			}
			//This is if the user does not enter in a number in between 5 and 100
			else if ((bet >= 5) || (bet < 100)){
				System.out.println("Please put in a valid number of coins");
			}
			else if (("no").equals(again)){
				System.out.println("Please restart the program");
				break;
			}
		}while (("yes").equals(again));

		//This is to create their win/ loss ratio, spins, number and percentage of times won and lost, 
		System.out.println("You have spun " + spinCount + " time(s).");
		System.out.println("You have won " + winCount + " time(s)");
		System.out.println("You have lost " +  lostCount + " times.");
		System.out.println("Your win/spin ratio is " + (winCount/spinCount)*100 + "%.");
		System.out.println("Your lose/spin ratio is " + (lostCount/spinCount)*100 +"%.");
		
	}
	
}