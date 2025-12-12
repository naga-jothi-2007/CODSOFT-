package numbergame;
import java.util.Scanner;

public class Task1 {
	public static void guessingnumbergame() {
		Scanner sc=new Scanner(System.in);
		int number=1+(int)(100*Math.random());
		int attempts=0;
		int k=5;
		boolean guessedcorrectly=false;
		System.out.println(" A number is choosen between 1 and 100");
		System.out.println("you have" + k + "attempts per round to   guess the correct number");
		while(!guessedcorrectly) {
			for(int i=0;i<k;i++) {
				System.out.println("enter your guess:");
				int guess=sc.nextInt();
				attempts++;
				if(guess==number) {
					System.out.println("congratulations!you guessed the correct number in" +attempts+ "attempts");
					guessedcorrectly=true;
					break;
				}
				else if(guess<number) {
					System.out.println("the number is greater than" +guess);
				}
				else {
					System.out.println("the number is less than" +guess);
				}
				
			}
			if(!guessedcorrectly) {
				System.out.println("you have used all " +k+ "attempts");
				System.out.println("do you want to continue guessing?(yes/no)");
				String response=sc.next();
				if(!response.equalsIgnoreCase("yes")) {
					System.out.println("gameover! the correct was" +number);
					break;
				}
				
			}
		}
		
		sc.close();
		
		
	}


public static void main(String[]args) {
	guessingnumbergame();
}
}

