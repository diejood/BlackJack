import java.util.Random;
import  java.util.Scanner;

//Main function to run game
public class BlackJack{
    public static void main( String [] args ) {

        char playAgain = 'y';
        Player player1 = new Player();
        Player computer = new Player();
        Scanner scanner = new Scanner( System.in);

        //Loop to run dice roll functions
        while (playAgain == 'y' &&  (player1.getTotalVal() <= 21 && computer.getTotalVal() <= 21) ){
            player1.rollDice();
            computer.rollDice();
            System.out.println("You rolled " + player1.getTotalVal() + " , " + "Now the computer is rolling");
            System.out.println("Computer role completed");
            System.out.println("Do you want to role again? Y/N?");
            playAgain = scanner.nextLine().charAt(0);
        } if (((player1.getTotalVal() > computer.getTotalVal()) && (player1.getTotalVal() <= 21)) ||
                ((player1.getTotalVal() < computer.getTotalVal()) && (player1.getTotalVal() > 21)) )   {
            System.out.println("You won! Your total is " + player1.getTotalVal() + " , " + "and the computer's score is " + computer.getTotalVal());
        } else if (((computer.getTotalVal() > player1.getTotalVal()) && (computer.getTotalVal() <= 21)) ||
                ((computer.getTotalVal() < player1.getTotalVal()) && (computer.getTotalVal() > 21))) {
            System.out.println("You Lost! Your total is " + player1.getTotalVal() + " , " + "and the computer's score is " + computer.getTotalVal());
        } else if ( player1.getTotalVal() == computer.getTotalVal()) {
            System.out.println("You were tied with a score" + "" + player1.getTotalVal());
        } else if ((player1.getTotalVal() > 21) && (computer.getTotalVal() > 21)) {
            System.out.println("Both players went over 21, no winner!");
        } else {
            System.out.println("Both players went over 21, no winner!");
        }
    }

    //Function to add random numbers to dice
    public static class Dice {
        private  int sides;
        private  int sideVal;

        public void roll() {
            Random randRoll = new Random();

            sideVal = randRoll.nextInt(sides) + 1;
        }

        public  int getSideVal() {
            return sideVal;
        }

        public Dice(int sidesGiven) {
            sides = sidesGiven;
            roll();
        }
    }

    //Function to add dice values to players
    public static class Player{
        private int die1Val;
        private int die2Val;
        private int totalVal;

        public void rollDice() {
            Dice die1 = new Dice(6);
            Dice die2 = new Dice(6);

            die1Val = die1.getSideVal();
            die2Val = die2.getSideVal();

            totalVal = totalVal + ( die1Val + die2Val);
        }

        public  int getTotalVal() {
            return totalVal;
        }

        public Player() {
            die1Val = 0;
            die2Val = 0;
            totalVal = 0;
        }
    }
}

//Sources of code structure from multiple examples from stackoverflow.com & stackexchange.com.

