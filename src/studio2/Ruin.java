package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		//Take input for variables
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		double startAmount = in.nextDouble();
		System.out.println("What is the probability you will win a single game?");
		double winChance = in.nextDouble();
		System.out.println("After reaching how much money a day will you leave?");
		double winLimit = in.nextDouble();
		System.out.println("How many times do you want to run the simulation?");
		int totalSimulations = in.nextInt();
		
		//Define some more variables
		double money = startAmount;
		double game = 0;
		int numberPlays = 0;
		String winOrLose = " ";
		int numLose = 0;
		
		//Simulate multiple days
		for(int c = 1; c <= totalSimulations; c++) {
			
			//simulate a single day
			while((money < winLimit) && (money > 0)) {
				game = Math.random();
				if (game <= winChance) {
					money++;
				}
				else {
					money--;
				}
				numberPlays++;
			}
			
			//define win or lose
			if(money >= winLimit) {
				winOrLose = "WIN";
			}
			else{
				winOrLose = "LOSE";
				numLose++;
			}
			
			//print statement and restart variables 
			System.out.println("Simulation " + c + ": " + numberPlays + " " + winOrLose);
			numberPlays = 0;
			money = startAmount;
		}
		
		//Calculate ruin rate and expected ruinRate
		double ruinRate = (numLose/(1.0 * totalSimulations));
		double aConstant = 1.0 * ((1-winChance)/winChance);
		double expectedRuin = 0;
		if (winChance == 0.5) {
			expectedRuin = 1 - (startAmount/winLimit);
		}
		else {
			expectedRuin = (Math.pow(aConstant, startAmount) - Math.pow(aConstant, winLimit))/
					(1 - Math.pow(aConstant, winLimit));
		}
		
		//Final print statement
		System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuin);
		
		/*
		 if(money >= winLimit) {
			System.out.println("success");
		}
		else {
			System.out.println("ruin");
		}
		*/
		
	}

}
