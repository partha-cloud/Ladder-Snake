package Player;

public class Game1 {

	public static void main(String[] args) {
		final int NO_PLAY=0;
		final int LADDER=1;
		final int SNAKE=2;
		int diceRoll = 1 + (int)( (Math.random() * 10) % 6);
		System.out.println("The Dice Rolled to: " + diceRoll);
		
		int option = (int) ( (Math.random() * 10) % 3 );
		switch(option) {
			case NO_PLAY:
				System.out.println("The option was to no play, hence the player will not advance");
				break;
			case LADDER:
				System.out.println("The option came to Ladder, the player move forward: " + diceRoll + " steps");
				break;
			case SNAKE:
				System.out.println("The option came to Snake, the player will backward: " + diceRoll + " steps");
				break;
			default:
				System.out.println("Some error occured, default case");
				break;
		}

	}

}
